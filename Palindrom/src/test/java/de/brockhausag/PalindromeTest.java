package de.brockhausag;

import de.brockhaus.Main;
import de.brockhaus.Palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    Palindrome palindrome = new Main();

    @Test
    public void isPalindromReturnsTrue() {
        var inputNumber = 1221;

        var actualOutput = palindrome.isPalindrome(inputNumber);

        assertTrue(actualOutput);
    }

    @Test
    public void isNotPalindromReturnsFalse() {
        var inputNumber = 1234;

        var actualOutput = palindrome.isPalindrome(inputNumber);

        assertFalse(actualOutput);
    }
}
