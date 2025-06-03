import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if (s.length() <= 1) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            Character lb = s.charAt(i);

            if (lb == '(' || lb == '{' || lb == '[') {
                if (!stack.isEmpty()) {
                    Character topB = stack.peek();
                }
                stack.push(lb);
            } else if (lb == ')' || lb == '}' || lb == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character topB = stack.pop();
                if (topB == '(' && lb != ')' ||
                        topB == '[' && lb != ']' ||
                        topB == '{' && lb != '}') {
                    return false;
                }
            } else {
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("(([]){})"));
    }
}



//import java.util.*;
//
////the main thing to know is that IN the stack ONLY the open functions are being put, as for the end-functions, it is directly compared with .pop()
////in this kind of problem its best to check what will NOT work
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        boolean flag = true;
//
//        Stack<String> stack = new Stack<>();
//
//        while (true) {
//            String line = sc.nextLine();
//
//            if(line.equals("x")){
//                break;
//            }
//
//            if (line.startsWith("func")) {
//                stack.push(line);
//
//            } else if (line.startsWith("endfunc")) {
//                //this is for the first input not to be endfunc
//                if(stack.isEmpty()){
//                    flag = false;
//                    break;
//                }
//
//                //if correct input compare the "func" and "endfunc"
//                String opening = stack.pop();
//                String openfunc = opening.substring(4);
//
//                String closefunc = line.substring(7);
//
//                //if in the middle it does not match then "break"
//                if(!openfunc.equals(closefunc)){
//                    flag = false;
//                    break;
//                }
//
//            }
//        }
//        //then of course we check for the end part, if the stack is filled or not
//        if(!stack.isEmpty()){
//            flag = false;
//        }
//
//        System.out.println(flag ? "Valid" : "Invalid");
//    }
//}