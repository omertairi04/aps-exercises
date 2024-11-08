import java.util.Scanner;

public class Main {
    public static int[] countBits(int n) {
        int[] array = new int[n + 1];
        array[0] = 0;
        int counter = 0; // to count when we need to increase bit
        for (int i = 1; i <= n; i++) {
            array[i] = array[i >> 1] + (i & 1);

        }

        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] bits = countBits(n);
        for (int i = 1; i <= n; i++) {
            System.out.println(bits[i]);
        }

    }
}