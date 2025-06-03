import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        DLL<Integer> dll = new DLL<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            dll.insertLast(x);
        }

        int M = scanner.nextInt();
        int k = scanner.nextInt();

        scanner.close();

        System.out.println("Original list: " + dll);

        DLLNode<Integer> mNode = dll.find(M);

        // Check if M exists in the list
        if (mNode == null) {
            System.out.println("Element M not found in the list.");
            return;
        }

        while (k > 0 && mNode.pred != null) {
            DLLNode<Integer> previous = mNode.pred;
            DLLNode<Integer> beforePrevious = previous.pred;
            DLLNode<Integer> next = mNode.succ;

            // Update previous' pointers
            if (beforePrevious != null) {
                beforePrevious.succ = mNode;
            } else {
                dll.insertFirst(mNode.element);  // If swapping first two elements, update head
            }

            mNode.pred = beforePrevious;
            previous.succ = next;

            if (next != null) {
                next.pred = previous;
            }

            // Swap M and previous
            mNode.succ = previous;
            previous.pred = mNode;

            // Update reference for next swap
            k--;
        }

        System.out.println("Modified list: " + dll);
    }
}
