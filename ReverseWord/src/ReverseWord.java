import java.util.Scanner;

public class ReverseWord {

    public static void printReversed(String word) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        String[] arr = new String[input];

        for (int i = 0; i < input; i++) {
            arr[i] = sc.next();
        }

        for (int i = 0; i < input; i++) {
            for (int j = arr[i].length() - 1; j >= 0; j--) {
                System.out.print(arr[i].charAt(j));
            }
            System.out.println();
        }
    }
}
