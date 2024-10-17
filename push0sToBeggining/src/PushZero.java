import java.util.Scanner;

public class PushZero {

    static void pushZerosToBeginning(int arr[], int n) {
        for (int i=0;i<n;i++) {
            for (int j=1;j<n;j++) {
                if (arr[j] == 0) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[] arr = new int[input];

        for (int i = 0; i < input; i++) {
            arr[i] = sc.nextInt();
        }

//        for (int i=1;i<arr.length;i++) {
//            if (arr[i] == 0) {
//                int temp = arr[i];
//                arr[i] = arr[i-1];
//                arr[i-1] = temp;
//                i = 0;
//            }
//        }
//        for (int i=0;i<arr.length;i++) {
//            for (int j=1;j<arr.length;j++) {
//                if (arr[j] == 0) {
//                    int temp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = temp;
//                }
//            }
//        }

        pushZerosToBeginning(arr, arr.length);

        System.out.println("Transformiranata niza e:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
