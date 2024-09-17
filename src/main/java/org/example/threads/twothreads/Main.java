package org.example.threads.twothreads;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * video tutorial: https://youtu.be/ec8PetXpKT0
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        AtomicBoolean found = new AtomicBoolean(false);

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a number: ");
        AtomicInteger num = new AtomicInteger(in.nextInt());

        in.nextLine();

        System.out.print("Enter a letter: ");
        char letter = in.nextLine().charAt(0);

        CountdownTask countdownTask = new CountdownTask(num, found);
        LetterSearchTask letterSearchTask = new LetterSearchTask(letter, found);

        executor.submit(letterSearchTask);
        executor.submit(countdownTask);

        // Await termination for a maximum of 30 seconds
        executor.awaitTermination(30, TimeUnit.SECONDS);
        executor.shutdown();
    }
}
