import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        var isValid = true;

        while(true) {

            String input = sc.nextLine();
            if (input.equals("x")) break;

            if (input.startsWith("func")) {
                stack.push(input);
            } else {

                if (stack.empty()) {
                    isValid = false;
                    break;
                }

                String top = stack.peek(); // e mer elementin fillim
                char topLast = top.charAt(top.length() - 1); // func1 -> 1
                char inputLast = input.charAt(input.length() - 1); // endfunc1 -> 1

                if (inputLast == topLast) { // njejt
                    stack.pop(); // remove
                }

            }

        }

        if (isValid && stack.empty()) System.out.println("Valid");
        else System.out.println("Invalid");

    }
}