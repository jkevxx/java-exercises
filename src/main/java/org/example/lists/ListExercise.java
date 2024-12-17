package org.example.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListExercise {

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>();
        Random rand = new Random();


        for(int i = 0; i < 10; i++){
            int number = rand.nextInt(90);
            elements.add(number);
        }

        for(Integer element : elements) {
            System.out.print(element + " ");
        }
    }
}
