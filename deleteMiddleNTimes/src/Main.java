
// You are give a singly linked list from which you have to delete the middle node N times.
// If the list has an even length pick you have to delete the smallest of the two middle nodes, if they have the same value delete the first one (left).
// Input:   first line  - number of elements,
//          second line - elements
//          third line  - N (number of times to delete the middle element)
//
// Example 1:
//  input:
//      6
//      1 2 3 4 5 6
//      3
//  output:
//      1 5 6
//
// Example 2:
//  input:
//      7
//      1 3 5 7 9 11 13
//      5
//  output:
//      1 13

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int amountToDelete = sc.nextInt();

        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(arr[i]);
        }

        if (list.size() % 2 == 0) {

        }

        SLLNode<Integer> current = list.getFirst();
    }
}