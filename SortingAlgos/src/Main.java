import java.util.Scanner;
public class Main {
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] < temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    private static void mergeSort(int[] arr) {
        int length = arr.length;
        if (length <= 1) return; //base case

        int middle = length / 2;
        int[] leftArr = new int[middle];
        int[] rightArr = new int[length - middle];

        int i = 0; // left array
        int j = 0; // right array

        for (; i <length;i++) {
            if (i < middle) {
                leftArr[i] = arr[i];
            } else {
                rightArr[j] = arr[i];
                j++;
            }
        }
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, arr);

    }

    private static void merge(int[] leftArr, int[] rightArr, int[] array) {
        int leftSize = array.length /2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; // i - original arr; l - left arr; r - right array

        // check the conditions for merging
        while (l < leftSize && r < rightSize) {
            if (leftArr[l] < rightArr[r]) {
                array[i] = leftArr[l];
                i++;
                l++;
            } else {
                array[i] = rightArr[r];
                i++;
                r++;
            }
        }
        while (l < leftSize) {
            array[i] = leftArr[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            array[i] = rightArr[r];
            i++;
            r++;
        }
    }

    private static void bubbleSortMax(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        insertionSort(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }
}