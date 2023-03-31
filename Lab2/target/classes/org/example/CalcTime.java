package org.example;

import java.util.concurrent.TimeUnit;

public class CalcTime {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); // Computation start time
        /* Do computation Here */
        // Sum:
//        Sum.main(new String[0]);
        // SumThreads:
        SumThreads.main(new String[0]);

        // The difference between the start time and the end time
        long difference = System.nanoTime() - startTime;
        // Print it out
        long minutesInDifference = TimeUnit.NANOSECONDS.toMinutes(difference);
        float secondsInDifference = difference / 1000000000.0f;
        System.out.format(
                "Total execution time: %d min, %.3f sec\n",
                minutesInDifference,
                secondsInDifference
        );
    }
}
