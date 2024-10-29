import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        DLL<Integer> list = new DLL<Integer>();

        for (int i = 0; i < n; i++) {
            list.insertLast(arr[i]);
        }

        DLLNode<Integer> current = list.getFirst();
        int valids = 0;
        while (current != null) {
            double leftAmount = 0, rightAmount = 0;
            int leftCounter = 0 , rightCounter = 0;
            double leftAvg = 0, rightAvg = 0;
            DLLNode<Integer> left = list.getFirst();
            while (left != current) {
                leftAmount += left.element;
                leftCounter++;
                left = left.succ;
            }
            leftAvg = leftAmount / leftCounter;

            DLLNode<Integer> right = current.succ;
            while(right != null) {
                rightAmount += right.element;
                rightCounter++;
                right = right.succ;
            }
            rightAvg = rightAmount / rightCounter;

            if (leftAvg > rightAvg) {
                valids++;
            }

            current = current.succ;
        }
        System.out.println(valids);

    }

}


