package org.example.virtualThread;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreadBestPractices {

    public static void main(String[] args) {
        char character = getCharacterInput();
        int number = getNumberInput();

        AtomicBoolean found = new AtomicBoolean(false);
        AtomicInteger counter = new AtomicInteger(number);

        Thread characterThread = Thread.ofVirtual()
                .name("CharacterSearch")
                .start(() -> searchCharacter(character, found));

        Thread numberThread = Thread.ofVirtual()
                .name("NumberCounter")
                .start(() -> countDown(counter, found));

        try {
            characterThread.join();
            numberThread.interrupt();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static char getCharacterInput() {
        String input = JOptionPane.showInputDialog("Enter a letter (A-Z):");
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        char character = input.toUpperCase().charAt(0);
        if (character < 'A' || character > 'Z') {
            throw new IllegalArgumentException("Input must be a letter between A and Z");
        }
        return character;
    }

    private static int getNumberInput() {
        String input = JOptionPane.showInputDialog("Enter a number:");
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format");
        }
    }

    private static void searchCharacter(char target, AtomicBoolean found) {
        for (char i = 'A'; i <= target; i++) {
            sleep(500);
            System.out.print(i + " ");

            if (i == target) {
                found.set(true);
                System.out.println("\nLetter " + i + " found in thread " + Thread.currentThread().getName());
            }
        }
    }

    private static void countDown(AtomicInteger counter, AtomicBoolean found) {
        while (!found.get()) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            int value = counter.getAndDecrement();
            if (value <= 0) {
                break;
            }
            System.out.println("Countdown: " + value);
            sleep(600);
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}