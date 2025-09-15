package com.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    @DisplayName("Testing 10 and 10")
    public void testAddNumbers1(){
        Calculator calc = new Calculator();
        int expected = 20;
        int actual = calc.addNumbers(10,10);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Testing 12 and 8")
    public void testAddNumbers2(){
        Calculator calc = new Calculator();
        int expected = 20;
        int actual = calc.addNumbers(12,8);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Testing -10 and 20")
    public void testAddNumbers3(){
        Calculator calc = new Calculator();
        int expected = 20;
        int actual = calc.addNumbers(-10,30);
        assertEquals(expected,actual);
        System.gc();
    }

}
