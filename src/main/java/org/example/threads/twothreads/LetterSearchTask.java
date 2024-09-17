package org.example.threads.twothreads;

import java.util.concurrent.atomic.AtomicBoolean;

public class LetterSearchTask implements Runnable {

    private final char letter;
    private final AtomicBoolean found;

    LetterSearchTask(char letter, AtomicBoolean found) {
        this.letter = letter;
        this.found = found;
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().setName("Thread-Letter");
            for (char ch = 'A'; ch <= letter; ++ch) {
                Thread.sleep(500);
                System.out.println(ch);

                if (ch == letter) {
                    found.set(true);
                    System.out.println("Letter " + ch + " found");
                    System.out.println("Thread name: " + Thread.currentThread().getName());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
