import java.util.Arrays;
import java.util.Scanner;

class QuarterlySales {

    private int numOfSales;
    protected int [] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }

    @Override
    public String toString() {
        return "QuarterlySales{" +
                "numOfSales=" + numOfSales +
                ", revenues=" + Arrays.toString(revenues) +
                ", quarterNo=" + quarterNo +
                '}';
    }

}

class SalesPerson {

    private String name;
    protected QuarterlySales [] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }
    @Override
    public String toString() {
        return "Name " + name + ", Quarters " + Arrays.toString(quarters);
    }

    public String getName() {
        return name;
    }
}


public class Main {


    public int sumSales(SalesPerson sp) {
        int sum = 0;
        for (int i=0;i<sp.quarters.length;i++) {
            for (int j=0;j<sp.quarters[i].revenues.length;j++) {
                sum += sp.quarters[i].revenues[j];
            }
        }

        return sum;
    }

    public static SalesPerson salesChampion(SalesPerson[] arr) {
        int max = arr[0].quarters[0].revenues[0];
        SalesPerson champion = arr[0];

        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr[i].quarters.length;j++) {
                if (arr[i].quarters[i].revenues[j] > max) {
                    max = arr[i].quarters[i].revenues[j];
                    champion = arr[i];
                }
            }
        }
        return champion;
    }

    public static void table(SalesPerson [] arr)
    {

    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        SalesPerson [] arr = new SalesPerson[n];
        for(int i=0;i<n;i++)
        {
            // enter your code here
        }

        table(arr);
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName());

    }
}
