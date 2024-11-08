package de.brockhaus;

public class Main implements Palindrome {

    public static void main(String[] args) {
        Palindrome palindrome = new Main();
        int number = 1221;
        System.out.println("Ist " + number + " ein palindrome? Antwort: " + palindrome.isPalindrome(number));
    }

    @Override
    public boolean isPalindrome(int number) {
        int originalNumber = number;
        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        return originalNumber == reversedNumber;
    }
}