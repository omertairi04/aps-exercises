import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> temp = new Stack<>();
        for (int i = 0; i < n; i++) {
            Integer input = sc.nextInt();
            sc.nextLine();

            if (!stack.isEmpty()) {
                Integer top = stack.peek();

                while (input < top) {
                    Integer popped = stack.pop();
                    temp.push(popped);
                    top = stack.peek();

                }
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }

                stack.push(input);
            } else {
                stack.push(input);
            }
        }

        System.out.println(stack);

    }
}