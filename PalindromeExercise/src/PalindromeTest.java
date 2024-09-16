import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeTest {
    Palindrome palindrome = new PalindromeImpl();

    @Test
    public void isPalindromReturnsTrue() {
        var inputNumber = 454;

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
