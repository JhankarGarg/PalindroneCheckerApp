import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean twoPointerMethod(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = processed.length() - 1;
        while (start < end) {
            if (processed.charAt(start) != processed.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean stackMethod(String input) {
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

    public static boolean dequeMethod(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < processed.length(); i++) {
            deque.addLast(processed.charAt(i));
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Palindrome Checker App Management System");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        long start1 = System.nanoTime();
        boolean result1 = twoPointerMethod(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = stackMethod(input);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean result3 = dequeMethod(input);
        long end3 = System.nanoTime();

        System.out.println("Two Pointer Result: " + result1 + " Time: " + (end1 - start1) + " ns");
        System.out.println("Stack Method Result: " + result2 + " Time: " + (end2 - start2) + " ns");
        System.out.println("Deque Method Result: " + result3 + " Time: " + (end3 - start3) + " ns");

        scanner.close();
    }
}