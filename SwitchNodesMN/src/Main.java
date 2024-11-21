import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        SLL<Integer> sll = new SLL<>();
        for (int i = 0; i < k; i++) {
            sll.insertLast(scanner.nextInt());
        }
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        SLLNode<Integer> current = sll.getFirst();
        SLLNode<Integer> m1 = null;
        SLLNode<Integer> n1 = null;
        while (current != null) {
            if (current.element == m) {
                m1 = current;
            }
            if (current.element == n) {
                n1 = current;
            }
            current = current.succ;
        }
        current = sll.getFirst();
        while (current != null) {
            if (current.element == m) {
                SLLNode<Integer> temp = current;
                sll.insertAfter(n1.element, current);
                sll.delete(current);
                current = temp.succ;
            }
            if (current.element == n) {
                SLLNode<Integer> temp = current;
                sll.insertAfter(m1.element, current);
                sll.delete(current);
                current = temp.succ;
            }
            current = current.succ;
        }
        System.out.println(sll);
    }
}