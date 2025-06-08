import java.util.*;

public class Main {
    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<String>();
//        String newStr = Arrays.toString(path.split("/"));
        String[] newStr = path.split("/");
        System.out.println(newStr);

        for (int i = 0; i < newStr.length; i++) {

            System.out.println(newStr[i]);
            if (!newStr[i].isEmpty() && !newStr[i].equals("..")) {
                if (!newStr[i].equals(".")) {
                    stack.push(newStr[i]);
                }
            } else if (newStr[i].equals("..") && !stack.empty()) {
                stack.pop();
            }

        }

        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        var res = simplifyPath("/.../a/../b/c/../d/./");
        System.out.println("RES IS: " + res);
//        System.out.println(Arrays.toString("/home/user/Documents/../Pictures".split("/")));
    }
}