package com.training;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest2 {

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
    @Test
    @DisplayName("2. Testing 10 and 10")
    @Order(2)
    public void testAddNumbers1(){
        int actual = calc.addNumbers(10,10);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("3. Testing 12 and 8")
    @Order(3)
    public void testAddNumbers2(){
        int actual = calc.addNumbers(12,8);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("1. Testing -80 and 20")
    @Order(1)
    public void testAddNumbers3(){
        expected = 100;
        int actual = calc.addNumbers(80,20);
        assertEquals(expected,actual);
    }


    @Test
    @DisplayName("Testing 90 converting as number")
    public void testConvertStringToInt(){
            String strNum = "9";
            Integer i = new Integer("90");
            String s = "90";
          int result =   calc.convertStringToInt(strNum);
          assertInstanceOf(Integer.class,result);
    }

    //Testing exception - NumberFormatException
    @Test
    @DisplayName("Testing Nine converting as number")
    public void testConvertStringToInt2(){
        String strNum = "9";
        assertThrows(NumberFormatException.class, () -> {
            int result = calc.convertStringToInt(strNum);
            assertInstanceOf(Integer.class,result);
        });
    }
}
