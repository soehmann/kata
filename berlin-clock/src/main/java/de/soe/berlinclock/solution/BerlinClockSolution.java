package de.soe.berlinclock.solution;


import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import de.soe.berlinclock.BerlinClock;

public class BerlinClockSolution implements BerlinClock {
    private static final String OFF = "O";
    private static final String RED = "R";
    private static final String YELLOW = "Y";

    @Override
    public String timeOf(final String time) {

        final String[] partials = time.split(":");
        final String[] lamps = {
                                  top(partials[2]),
                                  hours(partials[0]),
                                  singleHours(partials[0]),
                                  minutes(partials[1]),
                                  singleMinutes(partials[1])
                               };
        return Joiner.on("\n").join(lamps);
    }

    private String top(final String sec) {
        return Integer.valueOf(sec) % 2 == 0 ? YELLOW : OFF;
    }

    private String hours(final String hours) {
        return addOff(Strings.repeat(RED, Integer.valueOf(Integer.valueOf(hours) / 5)), 4);
    }

    private String singleHours(final String hours) {
        return addOff(Strings.repeat(RED, Integer.valueOf(hours) % 5), 4);
    }

    private String minutes(final String minutes) {
        return quarterOfMinutes(addOff(Strings.repeat(YELLOW, Integer.valueOf(minutes) / 5), 11));
    }

    private String quarterOfMinutes(final String time) {
        return time.replaceAll("YYY", "YYR");
    }

    private String singleMinutes(final String minutes) {
        return addOff(Strings.repeat(YELLOW, Integer.valueOf(minutes) % 5), 4);
    }

    private String addOff(final String time, final int length) {
        return time.concat(Strings.repeat(OFF, (length - time.length())));
    }
}
