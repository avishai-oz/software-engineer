package org.example;

public class SumThreads extends Thread {
    public static final long tenthOfSumNum = 4294967296L / 10; // 2^32 / 10
    private int partialSum;
    public SumThreads(int n){
        partialSum = n;
    }
    public int retSum(){
        return partialSum;
    }
    @Override
    public void run() {
        partialSum = 0;
        while(partialSum < tenthOfSumNum){
            partialSum += 1;
        }
    }
    public static void main(String[] args) {
        SumThreads[] threads = new SumThreads[10]; // create an array of threads
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            threads[i] = new SumThreads(0);
            threads[i].start();
        }
        for (SumThreads thread : threads) {
            try {
                thread.join(); // wait for the threads to terminate
                sum += thread.retSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The sum (multithreaded) is: " + (sum+7));
    }
}
