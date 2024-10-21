import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        System.out.print("{");
        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.print(arr[n - 1] + "}\n");

        double avg = (double) sum / n;
        boolean first = true;

        // Печатење на новата низа (елементи >= просекот)
        System.out.print("{");
        for (int i = 0; i < n; i++) {
            if (arr[i] >= avg) {
                if (!first) {
                    System.out.print(",");
                }
                System.out.print(arr[i]);
                first = false;
            }
        }
        System.out.println("}");

    }
}
