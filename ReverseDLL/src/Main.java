import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        sc.close();

        DLLNode<Integer> current = list.getLast();
        DLL<Integer> reversed = new DLL<>();

        while(current != null) {
            reversed.insertLast(current.element);
            current = current.pred;
        }

        System.out.println(reversed);

    }
}