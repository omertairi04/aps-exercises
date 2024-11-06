/*
Given a doubly linked list of integers, transform the list so that it is shuffled N times (N > 0 and read from standard input) as follows:
In each shuffle, the last element is placed inside the list after the nodes whose cumulative value is the maximum and less than or equal to the value
of the element being inserted.

The first line of the input gives the number of elements in the list M, the second line gives the number N, and the third line gives the elements in the list.

Input:

M = 14
N = 3
original list: 1 <-> 5 <-> 2 <-> 3 <-> 0 <-> 6 <-> 4 <-> 3 <-> 7 <-> 9 <-> 1 <-> 4 <-> 6 <-> 8
Mix 1:         1 <-> 5 <-> 2 <-> 8 <-> 3 <-> 0 <-> 6 <-> 4 <-> 3 <-> 7 <-> 9 <-> 1 <-> 4 <-> 6
The number 8 as the last element is removed from the end of the list and inserted after element 2,
because the sum 1+5+2 = 8 is the largest cumulative sum from the beginning of the list, and less than and equal to 8

Mix 2:         1 <-> 5 <-> 6 <-> 2 <-> 8 <-> 3 <-> 0 <-> 6 <-> 4 <-> 3 <-> 7 <-> 9 <-> 1 <-> 4
The number 6 as the last element is removed from the end of the list and inserted after element 5,

because the sum 1+5 = 6 is the largest cumulative sum from the beginning of the list, and less than and equal to 6

Mixing 3:      1 <-> 4 <-> 5 <-> 6 <-> 2 <-> 8 <-> 3 <-> 0 <-> 6 <-> 4 <-> 3 <-> 7 <-> 9 <-> 1
The number 4 as the last element is removed from the end of the list and inserted after element 1,

because the sum 1 = 1 is the largest cumulative sum from the beginning of the list, and less than and equal to 4

Output:
1 <-> 4 <-> 5 <-> 6 <-> 2 <-> 8 <-> 3 <-> 0 <-> 6 <-> 4 <-> 3 <-> 7 <-> 9 <-> 1

14
1 5 2 3 0 6 4 3 7 9 1 4 6 8
3

 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int [] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt(); // number of shuffles

        DLL<Integer> list = new DLL<>();

        for (int i = 0; i < m; i++) {
            list.insertLast(arr[i]);
        }

        while (n-- >= 0) {
            int sum = 0;
            DLLNode<Integer> lastNode = list.getLast();
            DLLNode<Integer> current = list.getFirst();

            while (sum <= lastNode.element) {
                sum += current.element;
                current = current.succ;
            }

            list.deleteFirst();
            list.insertAfter(lastNode.element, current);
            System.out.println(list);

        }

        System.out.println(list);

    }
}