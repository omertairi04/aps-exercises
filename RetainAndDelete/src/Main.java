import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int retain = sc.nextInt();
        int delete = sc.nextInt();

        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(arr[i]);
        }
        SLLNode<Integer> current = list.getFirst();
        while (current != null) {
            int retainCounter = 0;

            // Move to the m-th node to retain
            while (retainCounter < retain - 1 && current != null) {
                current = current.succ;
                retainCounter++;
            }

            // Start deleting from the node after the m-th retained node
            SLLNode<Integer> deleteStart = (current != null) ? current.succ : null;

            int deleteCounter = 0;
            while (deleteCounter < delete && deleteStart != null) {
                list.delete(deleteStart);
                deleteCounter++;
                deleteStart = deleteStart.succ;
            }

            // Reattach the retained nodes to the rest of the list
            if (current != null) {
                current.succ = deleteStart;
                current = deleteStart;
            }
        }


        System.out.println(list);

    }
}