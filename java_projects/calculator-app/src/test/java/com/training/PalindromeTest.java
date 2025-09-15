package com.training;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PalindromeTest {

    static Palindrome palindrome;
    @BeforeAll
    public static void setUp() throws Exception{
        palindrome = new Palindrome();
    }

    @AfterAll
    public static void bye(){
        palindrome = null;
    }

    @DisplayName("mom")
    @Order(1)
    @Test
    public void testPalindrome1() throws InvalidWordException {
        String word = "mom";
        boolean result = palindrome.checkPalindrome(word);
        assertTrue(result);
    }

    @DisplayName("dad")
    @Order(2)
    @Test
    public void testPalindrome2() throws InvalidWordException {
        String word = "dad";
        boolean result = palindrome.checkPalindrome(word);
        assertTrue(result);
    }

    @DisplayName("brother")
    @Order(3)
    @Test
    public void testPalindrome3() throws InvalidWordException {
        String word = "brother_name";
        boolean expected = false;
        boolean result = palindrome.checkPalindrome(word);
        assertFalse(result);
    }

    @DisplayName("sister")
    @Order(4)
    @Test
    public void testPalindrome4() throws InvalidWordException {
        String word = "sister_name";
        boolean result = palindrome.checkPalindrome(word);
       assertFalse(result);
    }


    @DisplayName("ofss")
    @Order(4)
    @Test
    public void testPalindromeOFSS() throws InvalidWordException {
        String word = "ofss";
        assertThrows(InvalidWordException.class, () -> {
            boolean result = palindrome.checkPalindrome(word);
            assertFalse(result);
        });
    }


}
