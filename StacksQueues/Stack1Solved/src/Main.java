import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        Boolean isValid = false;

        while (true) {
            String input = sc.nextLine();
            if (input.equals("x")) break;

            if (input.startsWith("end") && !stack.empty()) {
                String top = stack.peek();
                if (input.charAt(input.length() - 1) == top.charAt(top.length() - 1)) {
                    stack.pop();
                } else {
                    isValid = false;
                }
                } else if (!input.startsWith("end")) {
                stack.push(input);
                isValid = true;
            } else {
                isValid = false;
            }
        }

        if (!stack.empty()) isValid = false;


        if (isValid) System.out.println("Valid");
        else System.out.println("Invalid");


    }
}