package org.example.virtualThread;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreadMain {

    public static void main(String[] args) {

        AtomicBoolean found = new AtomicBoolean(false);

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            char character = JOptionPane.showInputDialog("Enter a letter").charAt(0);

            Runnable thread1 = () -> {
                try {
                    Thread.currentThread().setName("Thread-Character");
                    for (char i = 'A'; i <= character; i++) {
                        Thread.sleep(500);
                        System.out.print(i);

                        if (i == character) {
                            found.set(true);
                            System.out.println("Letter " + i + " found.");
                            System.out.println("Thread " + Thread.currentThread().getName());
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            };

            int number = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));
            AtomicInteger atomicInteger = new AtomicInteger(number);
            Runnable thread2 = () -> {
                Thread.currentThread().setName("Thread-Number");
                try {
                    while (!found.get()) {
                        Thread.sleep(600);
                        System.out.println(atomicInteger.getAndDecrement());
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            };

            executor.submit(thread1);
            executor.submit(thread2);
        }
    }
}
