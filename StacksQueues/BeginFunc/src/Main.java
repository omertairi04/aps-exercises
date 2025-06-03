import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        /*
        Starts :
        \begin{section}, \begin{subsection} or \begin{subsubsection}

         Ends:

         \end{section}, \end{subsection} or \end{subsubsection}

         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Boolean isValid = true;
        String begin = "\\begin{section}";
        String beginS = "\\begin{subsection}";
        String beginSS = "\\begin{subsubsection}";
        String end = "\\end{section}";
        String endS = "\\end{subsection}";
        String endSS = "\\end{subsubsection}";

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            if (input.equals(begin)
                    || input.equals(beginS)
                    || input.equals(beginSS)) {
                stack.push(input);
            } else if (input.equals(end)
                    || input.equals(endS)
                    || input.equals(endSS)
            ) {
                if (stack.isEmpty()) {
                    isValid = false;
                }

                if (isValid) {
                    String onTop = stack.pop();
                    if (input.equals(end) && !onTop.equals(begin)
                            || input.equals(endS) && !onTop.equals(beginS)
                            || input.equals(endSS) && !onTop.equals(beginSS)
                    ) {
                        isValid = false;
                    }
                }
            }
        }

        System.out.println(isValid);

    }
}