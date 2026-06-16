package org.example.parallelStream;

import java.util.Arrays;

public class ParallelStream {

    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        long startTime = System.nanoTime();

        Arrays.stream(numbers).forEach(n -> System.out.println("Sequential " + n));

        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds ");

        System.out.println("----------------");

        startTime = System.nanoTime();

        Arrays.stream(numbers).parallel().forEach(n -> System.out.println("Parallel " + n));

        endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds ");
    }

}
