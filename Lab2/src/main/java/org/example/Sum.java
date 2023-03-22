package org.example;

public class Sum {
    public static final long UINT_MAX = 4294967296L; // 2^32

    public static void main(String[] args) {
        long sum = 0;
        while (sum <= UINT_MAX) {
            sum += 1;
        }
        System.out.println("The sum (not multithreaded) is: " + sum);
    }
}
