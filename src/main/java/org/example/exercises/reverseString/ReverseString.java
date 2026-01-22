package org.example.exercises.reverseString;

import java.util.Scanner;

public class ReverseString {

    public static String RunLength(String str) {
        // code goes here

        String encodedString = "";
        int count = 1;

        for(int i = 0; i < str.length(); i++){
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i+1)){
                count++;
            } else {
                encodedString = encodedString.concat(Integer.toString(count)).concat(Character.toString(str.charAt(i)));
                count = 1;
            }
        }

        return reverseString(encodedString).concat(":46xzck5ju8");
    }

    private static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(RunLength(s.nextLine()));
    }
}
