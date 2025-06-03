/*
    Exercise: Valid HTML-like Tag Checker

You’re given lines of "pseudo-HTML" where each tag is either an opening tag like <tagname> or a closing tag like </tagname>. Tags are read one per line until "x" is entered.

Your job: determine if the tags are properly nested and matched — every opened tag must be closed in the correct order.

Valid:
<html>
<body>
<p>
</p>
</body>
</html>
x


Invalid:
<div>
<p>
</div>
</p>
x

 */
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        Boolean isValid = false;
        while (true) {
            String input = sc.nextLine();
            if (input.equals("x")) break;

            if (!input.startsWith("</")) {
                stack.push(input);
            } else {
                if (stack.empty()) {
                    isValid = false;
                    break;
                }

                String top = stack.peek();
                String element = top.substring(1, top.length() - 1);
                String inputEle = input.substring(2, input.length() - 1);
                if (inputEle.equals(element)) {
                    stack.pop();
                }
            }
        }

        if (stack.empty()) isValid = true;

        if (isValid) System.out.println("Valid");
        else System.out.println("Invalid");

    }
}








