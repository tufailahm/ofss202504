package com.training;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

//@TestMethodOrder(MethodOrderer.DisplayName.class)
public class PalindromeTest2 {
    private Palindrome palindrome ;

    @BeforeEach
    void beforeEach() {
        palindrome = new Palindrome();
    }

    @ParameterizedTest(name = "{index} - {0} is palindrome")
    @CsvFileSource(resources = "word.csv", numLinesToSkip = 1)
    public void testPalindrome4(String s) {
        boolean actual = palindrome.checkPalindrome(s);
        assertTrue(actual);
    }
}
