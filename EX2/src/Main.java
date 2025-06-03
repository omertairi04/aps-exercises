import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        SLL<String> list = new SLL<String>();
        SLL<String> newList = new SLL<String>();
        for (int i = 0; i < n; i++) {
            String word = new Scanner(System.in).nextLine();
            list.insertLast(word);
        }

        int L = scanner.nextInt();

        System.out.println(list);


        SLLNode<String> current = list.getFirst();

        while (current != null) {
            if (current.element.length() >= L) {
                newList.insertLast(current.element);
            }
            current = current.succ;
        }

        System.out.println(newList);

    }
}