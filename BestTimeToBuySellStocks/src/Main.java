import java.util.Scanner;

public class Main {
    public static int maxProfit(int[] prices) {


        if (prices.length <= 1) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Calculate profit by selling at the current price
            int currentProfit = prices[i] - minPrice;
            // Update maxProfit if currentProfit is higher
            maxProfit = Math.max(maxProfit, currentProfit);
            // Update minPrice if the current price is lower
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};

        int profit = maxProfit(prices);
        System.out.println(profit);
    }
}