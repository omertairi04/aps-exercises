import java.util.Scanner;
/*
8
1 2 3 4 5 6 7 8
3
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        int k = sc.nextInt();

        int listToDo = list.size() / k;
        int counter = 0;
        SLL<Integer> newList = new SLL<>();
        SLLNode<Integer> current = list.getFirst();
        while (current != null && counter != listToDo) {
            int vals = k;
            SLL<Integer> temp = new SLL<>();
            while (vals-- > 0) {
                temp.insertFirst(current.element);
                current = current.succ;
            }
            int size = temp.size();
            for (int i = 0; i < size; i++) {
                SLLNode<Integer> lastTemp = temp.getFirst();
                newList.insertLast(lastTemp.element);
                temp.deleteFirst();
            }
            counter++;
        }

        while (current != null) {
            newList.insertLast(current.element);
            current = current.succ;
        }

        System.out.println(newList);
    }
}