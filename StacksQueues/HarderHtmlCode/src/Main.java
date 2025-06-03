/*
🧩 Exercise: Extended HTML-like Validator with Self-Closing Tags

You’ll process input lines representing tags — same as before — but now some tags may be self-closing, meaning they don’t need a matching closing tag.
🔧 Tag Types:

    Opening tag: <tagname>

    Closing tag: </tagname>

    Self-closing tag: <tagname/>

Tags are on separate lines. Input ends with "x".

Valid:
<html>
<head>
<meta/>
</head>
<body>
<img/>
<p>
</p>
</body>
</html>
x


Invalid:
<div>
<img/>
<p>
</p>
x
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        boolean isValid = false;
        int x = 0;
//        String test = "<img/>";
//        System.out.println(test.substring(test.length()-2));

        while (true) {
            String input = sc.nextLine();
            if (input.equals("x")) break;

            // self-closing tags (no need to add to stack)
            if (input.startsWith("<") && (input.endsWith("/>"))) {
                // do nothing :|
                x++; // serves no purpose
            }
            else if (input.startsWith("</")) {
                if (stack.empty()) {
                    isValid = false;
                    break;
                }

                if (input.startsWith("</")) {
                    String top = stack.peek().substring(1, stack.peek().length() - 1);
                    String inputEl = input.substring(2, input.length() - 1);

                    if (inputEl.equals(top)) {
                        stack.pop();
                    }
                }

            } else {
                stack.push(input);
            }
        }

        if (stack.empty()) isValid = true;

        if (isValid) System.out.println("Valid");
        else System.out.println("Invalid");

    }
}