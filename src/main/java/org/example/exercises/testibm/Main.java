package org.example.exercises.testibm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> listBits = getOneBits(320);

        for (Integer item : listBits){
            System.out.println(item);
        }
    }


    public static List<Integer> getOneBits(int n) {

        List<Integer> numbers = new ArrayList<>();
        String[] binaryString = Integer.toBinaryString(n).split("");
        //Integer.bitCount(n);
       //System.out.println(Arrays.toString(binaryString));
        System.out.println(Integer.bitCount(n));
        numbers.add(Integer.bitCount(n));
        for ( int i = 0; i<binaryString.length; i++ ) {
            if (binaryString[i].equals("1")) {
                numbers.add(i+1);
            }
        }

        return numbers;
    }
}
