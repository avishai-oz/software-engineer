package org.example;

public class Sum {
    public static final long sumNum = 4294967296L; // 2^32

    public static void main(String[] args) {
        long sum = 0;
        while (sum <= sumNum) {
            sum += 1;
        }
        System.out.println("The sum (not multithreaded) is: " + sum);
    }
}
