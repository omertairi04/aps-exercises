/*

📚 Exercise: Nested Environments with Scope Constraints

You're given n lines that represent the start and end of nested math environments in a LaTeX-like syntax. Valid environments include:

\begin{theorem}
\begin{proof}
\begin{equation}

Each must end with:

\end{theorem}
\end{proof}
\end{equation}

✅ Valid Example:
6
\begin{theorem}
\begin{proof}
\begin{equation}
\end{equation}
\end{proof}
\end{theorem}

❌ Invalid Example:
4
\begin{proof}
\begin{equation}
\end{proof}
\end{equation}

⚠️ Extra Constraint:

You cannot start a theorem inside a proof.
You can start a proof inside a theorem.
You can nest equation inside both theorem and proof.
But nesting must always be closed properly.


 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        Boolean isValid = true;

        String beginTheorem = "\\begin{theorem}";
        String beginProof = "\\begin{proof}";
        String beginEquation = "\\begin{equation}";
        String endTheorem = "\\end{theorem}";
        String endProof = "\\end{proof}";
        String endEquation = "\\end{equation}";


        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            if (input.equals(beginTheorem)
                    || input.equals(beginProof)
                    || input.equals(beginEquation))
             {
                // check constraints here
                if (!stack.empty() && input.equals(beginTheorem)) {
                    String top = stack.peek();
                    if (top.equals(beginProof)) {
                        isValid=false;
                        break;
                    }
                }
                stack.push(input);
            }
            else if (input.equals(endTheorem)
                    || input.equals(endProof)
                    || input.equals(endEquation)) {
                if (stack.empty()) {
                    isValid = false;
                    break;
                }

                String top = stack.peek();

                if ((input.contains("theorem") && top.contains("theorem"))
                        || (input.contains("proof") && top.contains("proof"))
                || input.contains("equation") && top.contains("equation"))
                {
                    stack.pop();
                    isValid = true;
                } else {
                    isValid = false;
                }
            }
        }


        if (isValid && stack.empty()) System.out.println("Valid");
        else System.out.println("Invalid");


    }
}