package de.soe.berlinclock;

import de.soe.berlinclock.solution.BerlinClockSolution;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.is;


public class BerlinClockTest {

    private BerlinClock clock;

    /* 00:00:00 */
    private static final String NEXT_DAY_MIDNIGHT = "Y\n" +
                                                    "OOOO\n" +
                                                    "OOOO\n" +
                                                    "OOOOOOOOOOO\n" +
                                                    "OOOO";
    /* 24:00:00 */
    private static final String MIDNIGHT =  "Y\n" +
                                            "RRRR\n" +
                                            "RRRR\n" +
                                            "OOOOOOOOOOO\n" +
                                            "OOOO";

    /* 23:59:59 */
    private static final String SEC_BEFORE_MIDNIGHT =   "O\n"+
                                                        "RRRR\n"+
                                                        "RRRO\n"+
                                                        "YYRYYRYYRYY\n"+
                                                        "YYYY";
    /* 13:17:01 */
    private static final String RANDOM_TIME =   "O\n"+
                                                "RROO\n"+
                                                "RRRO\n"+
                                                "YYROOOOOOOO\n"+
                                                "YYOO";

    /* 12:00:00 */
    private static final String MIDDLE_OF_THE_DAY = "Y\n"+
                                                    "RROO\n"+
                                                    "RROO\n"+
                                                    "OOOOOOOOOOO\n"+
                                                    "OOOO";

    /* 00:00:01 */
    private static final String FIRST_SECOND =  "O\n"+
                                                "OOOO\n"+
                                                "OOOO\n"+
                                                "OOOOOOOOOOO\n"+
                                                "OOOO";

    /* 00:01:00 */
    private static final String FIRST_MINUTE =  "Y\n"+
                                                "OOOO\n"+
                                                "OOOO\n"+
                                                "OOOOOOOOOOO\n"+
                                                "YOOO";

    /* 00:05:00 */
    private static final String FIRST_FIVE_MINUTES =    "Y\n"+
                                                        "OOOO\n"+
                                                        "OOOO\n"+
                                                        "YOOOOOOOOOO\n"+
                                                        "OOOO";

    /* 00:15:00 */
    private static final String QUARTER_PAST_MIDNIGHT = "Y\n"+
                                                        "OOOO\n"+
                                                        "OOOO\n"+
                                                        "YYROOOOOOOO\n"+
                                                        "OOOO";

    /* 00:14:00 */
    private static final String FOURTEEN_MINUTES =  "Y\n"+
                                                    "OOOO\n"+
                                                    "OOOO\n"+
                                                    "YYOOOOOOOOO\n"+
                                                    "YYYY";

    /* 01:00:00 */
    private static final String FIRST_HOUR =    "Y\n"+
                                                "OOOO\n"+
                                                "ROOO\n"+
                                                "OOOOOOOOOOO\n"+
                                                "OOOO";

    /* 01:00:00 */
    private static final String FIRST_FIVE_HOURS =  "Y\n"+
                                                    "ROOO\n"+
                                                    "OOOO\n"+
                                                    "OOOOOOOOOOO\n"+
                                                    "OOOO";

    /* 09:00:00 */
    private static final String NINE_HOURS =    "Y\n"+
                                                "ROOO\n"+
                                                "RRRR\n"+
                                                "OOOOOOOOOOO\n"+
                                                "OOOO";

    @Before
    public void setUp() {
        // clock = anonymousClock();
        clock = new BerlinClockSolution();
    }

    private BerlinClock anonymousClock() {
        return new BerlinClock(){
            @Override
            public String timeOf(String time) {
                return null;
            }
        };
    }

    @Test
    public void nextDay() {
        final String time = "00:00:00";
        assertThat(clock.timeOf(time), is(equalToIgnoringWhiteSpace(NEXT_DAY_MIDNIGHT)));
    }

    @Test
    public void midnight() {
        final String time = "24:00:00";
        assertThat(clock.timeOf(time), is(equalToIgnoringWhiteSpace(MIDNIGHT)));
    }

    @Test
    public void secBeforeMidnight() {
        final String time = "23:59:59";
        assertThat(clock.timeOf(time), is(equalToIgnoringWhiteSpace(SEC_BEFORE_MIDNIGHT)));
    }

    @Test
    public void randomTime() {
        final String time = "13:17:01";
        assertThat(clock.timeOf(time), is(equalToIgnoringWhiteSpace(RANDOM_TIME)));
    }

    @Test
    public void inTheMiddleOfTheDay() {
        final String time = "12:00:00";
        assertThat(clock.timeOf(time), is(equalToIgnoringWhiteSpace(MIDDLE_OF_THE_DAY)));
    }

    @Test
    public void firstSecond() {
        final String time = "00:00:01";
        assertThat(clock.timeOf(time), is(equalToIgnoringWhiteSpace(FIRST_SECOND)));
    }

    @Test
    public void firstMinute() {
        final String time = "00:01:00";
        assertThat(clock.timeOf(time), is(equalToIgnoringWhiteSpace(FIRST_MINUTE)));
    }

    @Test
    public void firstFiveMinutes() {
        final String time = "00:05:00";
        assertThat(clock.timeOf(time), is(equalToIgnoringWhiteSpace(FIRST_FIVE_MINUTES)));
    }

    @Test
    public void quarterPastMidnight() {
        final String time = "00:15:00";
        assertThat(clock.timeOf(time), is(equalToIgnoringWhiteSpace(QUARTER_PAST_MIDNIGHT)));
    }

    @Test
    public void fourteenMinutes() {
        final String time = "00:14:00";
        assertThat(clock.timeOf(time), is(equalToIgnoringWhiteSpace(FOURTEEN_MINUTES)));
    }

    @Test
    public void firstHour() {
        final String time = "01:00:00";
        assertThat(clock.timeOf(time), is(equalToIgnoringWhiteSpace(FIRST_HOUR)));
    }

    @Test
    public void firstFiveHours() {
        final String time = "05:00:00";
        assertThat(clock.timeOf(time), is(equalToIgnoringWhiteSpace(FIRST_FIVE_HOURS)));
    }

    @Test
    public void nineHours() {
        final String time = "09:00:00";
        assertThat(clock.timeOf(time), is(equalToIgnoringWhiteSpace(NINE_HOURS)));
    }
}
