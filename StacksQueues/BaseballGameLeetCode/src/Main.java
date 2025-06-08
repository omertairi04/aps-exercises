import java.util.*;


public class Main {

    public static boolean isInteger(String s) {

        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static int calPoints(String[] operations) {
        var result = 0;
        var isValid = true;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i=0;i<operations.length; i++) {
            if (isInteger(operations[i])) {
                stack.push(Integer.parseInt(operations[i]));
            } else {
                if (operations[i].equals("+") && stack.size() >= 2) {
                    int popped = stack.pop();
                    int peeked = stack.peek();
                    int newVal = popped + peeked;
                    stack.push(popped);
                    stack.push(newVal);
                } else if (operations[i].equals("D")) {
                    int peeked = stack.peek();
                    var newRes = 2 * peeked;
                    stack.push(newRes);
                } else if (operations[i].equals("C")) {
                    stack.pop();
                }
            }
        }

        while (!stack.empty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {

        String[] ops = {"5", "2", "C", "D", "+"};
        var result = calPoints(ops);
        System.out.println(result);
    }

}