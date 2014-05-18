package de.soe.berlinclock;

import de.soe.berlinclock.solution.BerlinClockSolution;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;

public class App {
    public static void main( String[] args ) {

        final BerlinClock clock = new BerlinClockSolution();
        if(args.length == 0) {
            System.out.println(clock.timeOf(LocalTime.now().toString(DateTimeFormat.forPattern("HH:mm:SS"))));
        } else {
            System.out.println(clock.timeOf(args[0]));
        }
    }
}
