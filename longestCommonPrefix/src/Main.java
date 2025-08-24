import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        String[] strs =  {"flower", "flow","flight"};
        var result = "";

        outer:
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    break outer; // break from both loops
                }
            }
            result += strs[0].charAt(i);
        }

        System.out.println("result " + result);

    }
}