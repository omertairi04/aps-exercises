import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Stack<String> stack = new Stack<String>();
        var isValid = true;

        var i=0;
        while (i<n) {
            String input = sc.nextLine();
            if (!(input.charAt(0) == '#')) {
                if (stack.empty()) {
                    stack.push(input);
                } else
                {
                    String top = stack.peek();
                    var inputEndsWith = input.charAt(input.length() - 2);
                    var topEndsWith = top.charAt(top.length()-2);

                    if (inputEndsWith < topEndsWith) {
                        isValid = false;
                    } else {
                        stack.push(input);
                    }
                }
            } else {

                if (stack.empty()) {
                    isValid = false;
                    break;
                }

                String top = stack.peek();
                var topEndsWith = top.charAt(top.length()-2);
                var inputEndsWith = input.charAt(input.length() - 1);


                if (topEndsWith == 'y' && inputEndsWith == 'y') {
                    stack.pop();
                } else if (topEndsWith == inputEndsWith) {
                    stack.pop();
                } else {
                    isValid = false;
                }


            }


            i++;
        }

        if (isValid && stack.empty()) System.out.println("Valid");
        else System.out.println("Invalid");
    }
}