package com.training;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest3 {

    Calculator calc;
    int expected = 0;
    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All TESTS");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each TESTS");
        expected = 20;
        calc  =  new Calculator();
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each TESTS");
        calc  =  null;
        expected = 0;
    }
    @AfterAll
    static void afterAll() {
        System.gc();
    }

    @ParameterizedTest(name = "{index} - {0} and {1} should be {2}")
    @DisplayName("2. Testing 10 and 10")
    @Order(2)
    @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
    public void testAddNumbers(int n1,int n2,int expected){
        int actual = calc.addNumbers(n1,n2);
        assertEquals(expected,actual);
    }
}
