import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] subSums = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            DLL<Integer> dll = new DLL<>();
            for (int j = 0; j < m; j++) {
                int value = sc.nextInt();
                dll.insertLast(value);
                sum += value;
            }
            subSums[i] = sum;
        }

        int sums = 1;
        for (int i = 0; i < subSums.length; i++) {
            sums *= subSums[i];
        }
        System.out.println("Sum = " + sums);
    }
}