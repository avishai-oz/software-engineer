package org.example;

import java.util.concurrent.TimeUnit;

public class CalcTime {
    //    public static final double UINT_MAX = 4294967296L; // 2^32
    public static final long UINT_MAX = 4294967296L; // 2^32

    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Computation start time
        /* Do computation Here */

        // Sum:
        Sum.main(new String[0]);
        // SumThreads:

        // The difference between the start time and the end time
        long difference = System.nanoTime() - startTime;
        // Print it out
        long minutesInDifference = TimeUnit.NANOSECONDS.toMinutes(difference);
        long secondsInDifference =
                TimeUnit.NANOSECONDS.toSeconds(difference) - TimeUnit.MINUTES.toSeconds(minutesInDifference);
        System.out.format(
                "Total execution time: %d min, %d sec\n",
                minutesInDifference,
                secondsInDifference
        );
    }
}
