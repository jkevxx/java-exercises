package org.example.scanner;

import java.util.Scanner;

public class ScannerExercise {

    public static void main(String[] args) {
        String word1 = "";
        String word2 = "";

        Scanner keyword = new Scanner(System.in);
        System.out.print("Write a the first word: ");
        word1 = keyword.nextLine();
        System.out.print("Write a the second word: ");
        word2 = keyword.nextLine();

        if(word1.equals(word2)) {
            System.out.println("is the same word");
        } else {
            System.out.println("is not the same word");
        }
    }
}
