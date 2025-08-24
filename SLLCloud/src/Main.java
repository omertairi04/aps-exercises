import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        SLL<String> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            list.insertLast(input);
        }
        int k = sc.nextInt();
        sc.nextLine();

        System.out.println(list);
        SLL<String> newList = new SLL<>();
        SLLNode<String> curr = list.getFirst();

        while(curr != null) {
            if (curr.element.length() >= k) newList.insertLast(curr.element);
            curr = curr.succ;
        }

        SLLNode<String> c2 = newList.getFirst();

        System.out.println(newList);

    }
}