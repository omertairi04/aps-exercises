import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(arr[i]);
        }

        DLLNode<Integer> fromStart = list.getFirst();
        DLLNode<Integer> fromEnd = list.getLast();

        while (fromStart != fromEnd && fromStart.succ != fromEnd.succ) {
            // calculate sum of elements
            int sum = fromStart.element + fromEnd.element;
            // insert before fromStart
            list.insertBefore(sum, fromStart);
            if (fromStart.element > fromEnd.element) {
                list.insertBefore(fromStart.element, fromStart);
            } else if (fromStart.element < fromEnd.element) {
                list.insertBefore(fromEnd.element, fromStart);
            }
            DLLNode<Integer> temp = fromStart.succ;
            list.delete(fromStart);
            fromStart = temp;
            fromEnd = fromEnd.pred;
        }

        if (fromStart == fromEnd) {
            int sum = fromStart.element * 2; // sum itself if it’s the middle
            list.insertBefore(sum, fromStart);
            list.delete(fromStart);
        }

        System.out.println(list);
    }

}
