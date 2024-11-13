import java.util.Scanner;

public class Main {

    public static void makeZigZag(SLL<Integer> list) {
        if (list.size() <= 1) return;

        SLLNode<Integer> current = list.getFirst();

        while (current != null && current.succ != null) {
            if (current.element == 0) list.delete(current);
            else if (current.element >= 1 && current.succ.element >= 1) list.delete(current.succ);
            else if (current.element < 0 && current.succ.element < 0) {
                int absEl = Math.abs(current.element);
                list.insertAfter(absEl, current);
            }
            current = current.succ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        SLL<Integer> sll = new SLL<>();
        for (int i = 0; i < n; i++) {
            sll.insertLast(arr[i]);
        }

        System.out.println(sll);
        makeZigZag(sll);
        System.out.println(sll);
    }
}