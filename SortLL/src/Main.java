import java.util.Scanner;

public class Main {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortLL(SLL<Integer> list) {
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            SLLNode<Integer> current = list.getFirst();

            // Traverse the list and perform swaps as needed
            while (current != null && current.succ != null) {
                if (current.element > current.succ.element) {
                    // Swap the values
                    int temp = current.element;
                    current.element = current.succ.element;
                    current.succ.element = temp;

                    // Mark that a swap has occurred
                    swapped = true;
                }
                current = current.succ;  // Move to the next node
            }
        }
    }

    public static void removeDuplicatedSLL(SLL<Integer> list) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        SLL<Integer> sll = new SLL<>();
        for (int i = 0; i < n; i++) {
            sll.insertLast(arr[i]);
        }

        bubbleSortLL(sll);



    }
}