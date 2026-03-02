import java.util.Scanner;
import java.util.Stack;

class PalindromeChecker {

    public boolean checkPalindrome(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < processed.length(); i++) {
            stack.push(processed.charAt(i));
        }
        for (int i = 0; i < processed.length(); i++) {
            if (processed.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Palindrome Checker App Management System");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is not a Palindrome.");
        }

        scanner.close();
    }
}