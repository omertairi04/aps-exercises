import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        SLL<String> list = new SLL<String>();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            list.insertLast(s);
        }

        int L = scanner.nextInt();

        System.out.println(list);

        SLLNode<String> current = list.getFirst();
        while (current != null) {
            if (current.element.length() >= L) {
                SLLNode<String> nodeToInsert = new SLLNode<>("Target", current.succ);
                current.succ = nodeToInsert;
                current = nodeToInsert;
            }
            current = current.succ;
        }

        System.out.println(list);

    }
}