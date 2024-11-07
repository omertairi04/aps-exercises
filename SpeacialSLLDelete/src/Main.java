/*
You are given a single linked list with integer nodes. Additionally, you are given one more integer M (M>1). You need to delete every M-th element from the list.

Input: In the first line from the input the number of elements in the list is given, and then in the next line the elements themselves. In the last line, the integer M is given.

Output: The transformed list (with every M-th element deleted) should be printed at the output.

Pay attention:

1. All the needed code for the structure that you need to use is given. The test class SpecialSLLDelete.java is also given, with completely implemented input and output. You only need to change the code of the void specialDelete(SLL<Integer> list, int m) method.


2. You must not change the main method !
For example:

Input	Result
7
1 2 5 6 3 4 7
3
 */


import java.util.Scanner;

public class Main {
    // TODO: implement
    public static void specialDelete(SLL<Integer> list, int m) {

        SLLNode<Integer> current = list.getFirst();
        int currentIndex = 1;

        for (int i=0;i<list.size();i++) {
            if (currentIndex == m) {
                list.delete(current);
                currentIndex = 0;
            }
            current = current.succ;
            currentIndex++;
        }

        System.out.println(list);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(arr[i]);
        }
        specialDelete(list, m);
    }
}