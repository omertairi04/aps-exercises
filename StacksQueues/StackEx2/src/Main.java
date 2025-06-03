import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char chars = str.charAt(i);
            int numericValue = Character.getNumericValue(chars);
            if (numericValue >= 0) {
                stack.push(numericValue);
            } else if (
                    chars == '+' || chars == '-'
                            || chars == '*' || chars == '/') {
                Integer o1 = stack.pop();
                Integer o2 = stack.pop();

                int result = -1;
                if (chars == '+') result = o1 + o2;
                if (chars == '-') result = o1 - o2;
                if (chars == '*') result = o1 * o2;
                if (chars == '/') result = o1 / o2;

                stack.push(result);
            }

        }

        System.out.println(stack.pop());


    }
}