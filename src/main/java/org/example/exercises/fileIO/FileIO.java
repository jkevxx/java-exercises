package org.example.exercises.fileIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIO {

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter (new FileWriter("output.txt"));
        writer.write("This is test in a file");
        writer.close();

        try (Scanner reader = new Scanner(new File("output.txt"))) {
            while (reader.hasNextLine()){
                System.out.println(reader.nextLine());
            }
        }
    }
}
