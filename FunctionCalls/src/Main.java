import java.util.*;

public class Main {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        HashMap<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            System.out.println("Input: " + input);
            String[] split = input.split(" ");

            if (split.length >= 2) {
                stack.push(split[1]);
                map.put(split[1], map.getOrDefault(split[1]+=1, 1));
            } else {
                stack.pop();
            }
        }

        int maxKey = -1;
        String maxValue = "";
        for (String key : map.keySet()) {
            if (map.get(key) > maxKey) {
                maxKey = map.get(key);

            }
        }

        System.out.println("MAX " + maxKey);

    }
}