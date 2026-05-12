package org.example.testing;

import java.util.List;
import java.util.stream.Collectors;

public class Example {

    public int add(int a, int b){
        return a + b;
    }

    public boolean checkPositive(int num){
        if ( num < 0 ){
            throw new IllegalArgumentException("The number it cannot be negative");
        }
        return true;
    }

    public int countLetters(String text){
        return (int) text.chars()
                .filter(tx -> tx == 'a')
                .count();
    }

    public boolean hasElement(List<String> list, String element){
        return list.contains(element);
    }

    public String revertText(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    public long factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Factorial cannot be negative");
        }
        long result = 1;
        for (int i = 1; i <= num; i++){
            result *= i;
        }
        return result;
    }

    public boolean isPrime(int num) {
        if (num <= 1){
            return false;
        }
        for (int i = 2; i *i <= num; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }

    public String messageWithDelay() throws InterruptedException {
        Thread.sleep(5000);
        return "Ready after delay";
    }

    public List<String> convertToString(List<Integer> list) {
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public double calculateMiddle(List<Integer> list) {
        if (list == null || list.isEmpty()){
            throw new IllegalArgumentException("The list cannot be null or empty");
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public String convertListToString(List<String> list){
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));
    }


}
