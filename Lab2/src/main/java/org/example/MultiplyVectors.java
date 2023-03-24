package org.example;

import java.util.Random;
import java.util.Scanner;
//import java.util.stream.IntStream;

public class MultiplyVectors extends Thread {
    long[] v1, v2;
    long res = 0 ;

    public MultiplyVectors(long[] vec1, long[] vec2 , int part , int pos){
        v1 = vec1;
        v2 = vec2;
        int stop = vec1.length;

        for (int i = pos; i < stop; i= i+part) {
            res += v1[i] * v2[i];
        }
    }
    public long res(){
        return res;
    }
    public synchronized void run() {

    }

    public static void main(String[] args) {
        int n;  // vector size
        int N;  // number of threads

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the vector size: ");
        n = input.nextInt();
        System.out.println("Please enter the number of threads (greater than 2): ");
        N = input.nextInt();

        long[] vec1 = new long[n];
        long[] vec2 = new long[n];
        long result =0;

        Random rng = new Random();
        for(int i=0; i<n; i++){
            vec1[i] = rng.nextInt();
            vec2[i] = rng.nextInt();
        }
        MultiplyVectors[] threads = new MultiplyVectors[N]; // create an array of threads
        for (int i = 0; i < N; i++) {
            threads[i] = new MultiplyVectors(vec1, vec2 , N , i );
        }

        for(MultiplyVectors thread : threads){
            try {
                thread.join(); // wait for the threads to terminate
                result += thread.res();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       //print vec 1
        System.out.print("Vector 1: [");
        for (int i=0 ; i<n ; i++){
            System.out.print(vec1[i] + " ,");
        }
        System.out.println("]");

        //print vec 2
        System.out.print("Vector 2: [");
        for (int i=0 ; i<n ; i++){
            System.out.print(vec2[i] + " ,");
        }
        System.out.println("]");

        //print vec 3
        System.out.print("sum : [");
        System.out.print(result);
        System.out.println("]");
    }
}
