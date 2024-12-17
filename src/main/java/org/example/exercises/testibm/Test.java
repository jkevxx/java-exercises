package org.example.exercises.testibm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(49);
        numbers.add(23);

        List<String> romanWords = romanizer(numbers);

//        for (String word : romanWords){
//            System.out.println(word);
//        }
//        System.out.println(romanWords);
    }

    public static List<String> romanizer(List<Integer> numbers) {

        List<String> romanNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            romanNumbers.add(getRomanNumber(numbers.get(i)));
        }
        return romanNumbers;
    }

    public static String getRomanNumber ( Integer num){
        Map<Integer, String> dictionaryRoman = new HashMap<>();
        dictionaryRoman.put(1, "I");
        dictionaryRoman.put(2, "II");
        dictionaryRoman.put(3, "III");
        dictionaryRoman.put(4, "IV");
        dictionaryRoman.put(5, "V");
        dictionaryRoman.put(6, "VI");
        dictionaryRoman.put(7, "VII");
        dictionaryRoman.put(8, "VIII");
        dictionaryRoman.put(9, "IX");
        dictionaryRoman.put(10, "X");
        dictionaryRoman.put(40, "XL");
        dictionaryRoman.put(50, "L");
        dictionaryRoman.put(90, "XC");
        dictionaryRoman.put(100, "C");
        dictionaryRoman.put(400, "CD");
        dictionaryRoman.put(500, "D");
        dictionaryRoman.put(900, "CM");
        dictionaryRoman.put(1000, "M");

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i : values) {
            while (num >= i) {
                sb.append(dictionaryRoman.get(i));
                System.out.println("before "+num);
                num -= i;
                System.out.println("after "+num);
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
}
