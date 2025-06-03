import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        boolean isValid = true;

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("x")) break; // Stop reading input

            if (input.startsWith("end")) {
                String funcName = input.substring(3).trim(); // Extract function name after "end"

                if (stack.isEmpty() || !stack.peek().equals(funcName)) {
                    isValid = false; // No matching function or wrong order
                    break;
                }
                stack.pop(); // Function correctly closed
            } else {
                stack.push(input); // Push function name
            }
        }

        if (!stack.isEmpty()) isValid = false; // Unmatched opened functions

        System.out.println(isValid ? "Valid" : "Invalid");
    }
}
