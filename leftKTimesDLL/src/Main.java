import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DLL<Integer> dll = new DLL<>();

        int n = sc.nextInt();
        sc.nextLine();

        String str = sc.nextLine();
        var element = str.split(" ");

        for (int i = 0; i < element.length; i++) {
            dll.insertLast(parseInt(element[i]));
        }

        System.out.println(dll.toString());

        int k =  sc.nextInt();
        sc.nextLine();

        sc.close();

        while (k-- > 0) {
            DLLNode leftEl = dll.getFirst();
            DLLNode rightEl = dll.getLast();

            dll.insertAfter(parseInt(leftEl.element.toString()), rightEl);
            dll.delete(leftEl);

        }

        System.out.println("AFTER");
        System.out.println(dll.toString());


    }
}