package org.example;

import java.util.Random;
import java.util.Scanner;
//import java.util.stream.IntStream;

public class MultiplyVectors extends Thread {
    int[] v1, v2;
    int res = 0 ;

    public MultiplyVectors(int[] vec1, int[] vec2 , int part , int pos){
        v1 = vec1;
        v2 = vec2;
        int start = pos*part;
        int stop = (pos+1)*part -1;

        if (part == 1){
            res += v1[pos]*v2[pos];
        }

        for (int i = start ; i <= stop ; i++){
            res += v1[i]*v2[i];
        }
    }
    public int res(){
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

        int[] vec1 = new int[n];
        int[] vec2 = new int[n];
        int result =0;

        Random rng = new Random();
        for(int i=0; i<n; i++){
            vec1[i] = rng.nextInt(10);
            vec2[i] = rng.nextInt(10);
        }
        MultiplyVectors[] threads = new MultiplyVectors[N]; // create an array of threads
        for (int i = 0; i < N; i++) {
            threads[i] = new MultiplyVectors(vec1, vec2 , (n/N) , i );
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

//        System.out.println("Vector 1: " + vec1 + " multiplied by Vector 2: " + vec2 + " is:");
//        System.out.println(vec3);
    }
}
