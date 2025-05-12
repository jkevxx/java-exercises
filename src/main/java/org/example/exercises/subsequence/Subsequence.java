package org.example.exercises.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem https://www.algoexpert.io/questions/validate-subsequence
 * https://youtu.be/Xr2CJ2DJP1g
 */

public class Subsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        for (int i = 0, count = 0; i < array.size(); i++) {
            if (array.get(i).equals(sequence.get(count))) {
                count++;
            }

            if(count >= sequence.size()){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        boolean isvalid = isValidSubsequence(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)),
                new ArrayList<>(Arrays.asList(1, 8, 4, 5))
        );
        // [5, 1, 22, 25, 6, -1, 8, 10]
        // [1, 6, -1, 10]

        System.out.println(isvalid);
    }
}
