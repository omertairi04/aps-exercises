import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] possible = new int[n];

        for (int i = 0; i < n; i++) {
            possible[i] = sc.nextInt();
        }
        sc.close();

//        mso omer
        int lightCounter = 0;


        System.out.println(lightCounter);
    }
}