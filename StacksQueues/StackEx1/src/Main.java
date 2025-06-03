import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        boolean isValid = true;
        System.out.println(str);
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')' || str.charAt(i) == ']') {
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }

                Character top = stack.peek();

                if (top == '(' && str.charAt(i) == ')'
                        ||
                        top == '[' && str.charAt(i) == ']') {
                    stack.pop();
                } else {
                    isValid = false;
                    break;
                }


            }

        }

        if (!stack.isEmpty()) {
            isValid = false;
        }

        System.out.println("Valid: " + isValid);

    }
}