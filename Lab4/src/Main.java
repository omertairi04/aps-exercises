/*
We are given an array of N numbers. Using the method "divide and conquer" write a binary search algorithm that searches for a given number M. If the number is found, print the position of the number in the array. If the number is not in the array, print "Ne postoi".

Input: The first number in the input is the size of the array N, and the number we are searching M. Then in the next line are the array elements.

Output: The position of the number we are searching, or "Ne postoi" if no such number exists in the array.

EX: 5 3
    1 2 3 4 5  -> 2

 */

import java.util.Scanner;

public class Main {
    private static void bubbleSort(int[] array) {
        for (int i=0;i<array.length-1;i++) {
            for (int j=0;j<array.length - i - 1;j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int value = array[mid];
            if (value < target) low = mid + 1;
            else if (value > target) high = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numToSearch = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // sort the array
        bubbleSort(arr);
        int index = binarySearch(arr, numToSearch);
        if (index == -1) {
            System.out.println("Ne postoi");
        } else {
            System.out.println(index);
        }
    }
}