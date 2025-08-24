import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int element = sc.nextInt();

        SLL<Integer> sll = new SLL<>();
        for (int i = 0; i < n; i++) {
            sll.insertLast(arr[i]);
        }

        int occurrence = 0;
        SLLNode<Integer> nodeOcc = sll.find(element);

        for (int i = 0; i < n; i++) {
            if (arr[i] == element) {
                occurrence++;
            }
        }

        if (occurrence % 2 != 0) {
            sll.insertAfter(element, nodeOcc);
        }

        System.out.println(sll);

    }
}