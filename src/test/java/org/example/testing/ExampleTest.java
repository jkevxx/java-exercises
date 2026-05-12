package org.example.testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    Example example = new Example();

    @Test
    void add() {
        // Given
        int a = 3;
        int b = 8;

        // When
        int total = example.add(a, b);

        // Then
        assertEquals(11, total);
        assertInstanceOf(Integer.class, total);
    }

    @Test
    void checkPositive() {
        boolean value = example.checkPositive(3);

        assertTrue(value);
    }

    @Test
    void countLetters() {
        int total = example.countLetters("java language");
        assertEquals(4, total);
    }

    @Test
    void hasElement() {
        List<String> myList = List.of("Apple", "Banana", "Mango", "Watermelon");
        boolean value = example.hasElement(myList, "Apple");

        assertTrue(value);
    }

    @Test
    void revertText() {
        String letter = example.revertText("mango");

        assertEquals("ognam", letter);
    }

    @Test
    void factorial() {

        long num = example.factorial(5);

        assertEquals(120, num);

    }

    @Test
    void isPrime() {

        boolean value1 = example.isPrime(4);
        assertFalse(value1);

        boolean value2 = example.isPrime(11);
        assertTrue(value2);
    }

    @Test
    void messageWithDelay() throws InterruptedException {

        String value = example.messageWithDelay();

    }

    @Test
    void convertToString() {

        List<Integer> myList = List.of(1,2,3,4);

        List<String> myStringList = example.convertToString(myList);

        //assertInstanceOf(String, myStringList);


    }

    @Test
    void calculateMiddle() {
    }

    @Test
    void convertListToString() {
    }
}