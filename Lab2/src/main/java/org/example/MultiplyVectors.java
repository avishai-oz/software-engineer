package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MultiplyVectors implements Runnable {
    int[] v1, v2, vOut;
    public MultiplyVectors(int[] vec1, int[] vec2){
        v1 = vec1;
        v2 = vec2;
    }
    public void run() {

    }

    public static void main(String[] args) {
        int n;  // vector size
        int N;  // number of threads

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the vector size: ");
        n = input.nextInt();
        System.out.println("Please enter the number of threads (greater than 2): ");
        N = input.nextInt();

        int[] vec1 = new int[n];
        int[] vec2 = new int[n];
        int[] vec3 = new int[n];

        Random rng = new Random();
        for(int i=0; i<n; i++){
            vec1[i] = rng.nextInt();
            vec2[i] = rng.nextInt();
        }
        Thread[] threads = new Thread[N]; // create an array of threads
        for (int i = 0; i < N; i++) {
            threads[i] = new Thread(new MultiplyVectors(vec1, vec2));
        }

        for(Thread thread : threads){
            try {
                thread.join(); // wait for the threads to terminate
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Vector 1: " + vec1 + " multiplied by Vector 2: " + vec2 + " is:");
        System.out.println(vec3);
    }
}
