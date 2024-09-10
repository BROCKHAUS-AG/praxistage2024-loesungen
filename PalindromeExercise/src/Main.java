public class Main implements Palindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(int number) {
        int r, sum = 0, temp;

        temp = number;
        while (number > 0) {
            r = number % 10;
            sum = (sum * 10) + r;
            number = number / 10;
        }
        return temp == sum;
    }
}