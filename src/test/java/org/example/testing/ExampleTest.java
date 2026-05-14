package org.example.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    private Example example;

    @BeforeEach
    public void init(){
        this.example = new Example();
    }

    @Test
    void testAdd() {
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
    void testCheckPositive() {
        boolean value = example.checkPositive(3);

        assertTrue(value);
    }

    @Test
    void testCheckPositiveError(){
        int number = -4;

        assertThrows(IllegalArgumentException.class, () -> {
            example.checkPositive(number);
        });
    }

    @Test
    void testCountLetters() {
        int total = example.countLetters("java language");
        assertEquals(4, total);
    }

    @Test
    void testHasElement() {
        List<String> myList = List.of("Apple", "Banana", "Mango", "Watermelon");
        boolean value = example.hasElement(myList, "Apple");

        assertTrue(value);
    }

    @Test
    void testRevertText() {
        String letter = example.revertText("mango");

        assertEquals("ognam", letter);
    }

    @Test
    void testFactorial() {
        long num = example.factorial(5);

        assertEquals(120, num);
    }

    @Test
    void testFactorialError(){
        int num = -6;

        assertThrows(IllegalArgumentException.class, () -> {
            example.factorial(num);
        });
    }

    @Test
    void testIsPrime() {
        boolean value2 = example.isPrime(11);
        assertTrue(value2);
    }

    @Test
    void testIsPrimeLessThanOne() {
        boolean value1 = example.isPrime(1);
        assertFalse(value1);
    }

    @Test
    void testIsNotPrime() {
        boolean value1 = example.isPrime(4);
        assertFalse(value1);
    }

    @Test
    void testMessageWithDelay() throws InterruptedException {
        String value = example.messageWithDelay();
        assertEquals("Ready after delay", value);
    }

    @Test
    void convertToString() {
        List<Integer> myList = List.of(1,2,3,4);

        List<String> myStringList = example.convertToString(myList);
        assertEquals(List.of("1", "2", "3", "4"), myStringList);
    }

    @Test
    void testCalculateMiddle() {
        List<Integer> numbers = List.of(1,2,3);

        double result = example.calculateMiddle(numbers);

        assertEquals(2, result);
    }

    @Test
    void testCalculateMiddleNull() {
        List<Integer> numbers = null;

        assertThrows(IllegalArgumentException.class, () -> {
           example.calculateMiddle(numbers);
        });
    }

    @Test
    void testCalculateMiddleEmpty() {
        List<Integer> numbers = Collections.emptyList();

        assertThrows(IllegalArgumentException.class, () -> {
            example.calculateMiddle(numbers);
        });
    }

    @Test
    void convertListToString() {
    }
}