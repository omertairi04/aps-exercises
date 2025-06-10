
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Stack<String> stack = new Stack<>();
        var isValid = true;

        int i =0;
        while (i < n) {

            String input = sc.nextLine();
            if (input.startsWith("\\begin")) {

                if (stack.empty()) stack.push(input);
                else {

                    String top = stack.peek();
                    // beginLen = 15
                    // bS = 18
                    // bSS = 21

                    if (input.length() >= top.length()) {
                        stack.push(input);
                    } else{
                        isValid = false;
                    }
                }
            } else {

                if (stack.empty()) isValid =false;
                else {
                    String top = stack.peek();
                    // endL = 13
                    // endS = 18
                    // endSS = 19

                    if (input.length() == top.length() - 2) {
                        stack.pop();
                    }
                }

            }

            i++;
        }

        if (isValid && stack.empty()) System.out.println("Valid");
        else System.out.println("Invalid");

    }
}