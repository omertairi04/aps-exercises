import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int adults = sc.nextInt();
        int children = sc.nextInt();
        int price = 100;
        int min, max;

        if (adults < children) {
            int temp = children - adults;
            min = (adults + temp) * price;
            max = (adults + children - 1) * price;

        } else {
            min = adults * price;
            max = (adults * price) + (children * price) - price; // -price because for one child is free
        }

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}