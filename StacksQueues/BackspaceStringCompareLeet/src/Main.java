import java.util.*;
public class Main {
    public static boolean backspaceCompare(String s, String t) {

        Stack<Character> stackS = new Stack<Character>();
        Stack<Character> stackT = new Stack<Character>();

        for (int i=0;i<s.length();i++){
            if (s.charAt(i) != '#') {
                stackS.push((s.charAt(i)));
            } else {
                if (!stackS.empty()) {
                    stackS.pop();
                }
            }

        }

        for (int i=0;i<t.length();i++){
            if (t.charAt(i) != '#') {
                stackT.push(t.charAt(i));
            } else {
                if (!stackT.empty()) {
                    stackT.pop();
                }
            }
        }

        return stackS.equals(stackT);
    }

    public static void main(String[] args) {

        var res = backspaceCompare( "a#c","b");
        System.out.println(res);

    }
}