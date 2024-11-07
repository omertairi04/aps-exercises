import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            DLL<Integer> dll = new DLL<>();
            for (int j = 0; j < m; j++) {
                int value = sc.nextInt();
                dll.insertLast(value);
                sum += value;
            }
            list.insertLast(sum);
        }

        int sums = 1;
        int iterator = 0;
        DLLNode<Integer> head = list.getFirst();
        while (iterator < list.getSize()) {
            sums *= head.element;
            head = head.succ;
            iterator++;
        }
        System.out.println("Sum = " + sums);
    }
}