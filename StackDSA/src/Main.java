import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        /*
        Stack - a LIFO DSA(LIFO)
         */

        Stack<String> stack = new Stack<String>();
//        System.out.println(stack.empty());

        stack.push("Minecraft");
        stack.push("Skyrim");
        stack.push("Doom");
        stack.push("Borderlands");
        stack.push("FFVII");

        stack.pop(); // removes last inputted item

        String favGame = stack.pop();
        System.out.println(stack.peek()); // prints the top item

        System.out.println(stack.search("Skyrim")); // starts from 1
    }
}