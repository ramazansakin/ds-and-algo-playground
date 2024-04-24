package com.rsakin.practise.coding.array;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        // Test case 1: Prices in ascending order
        int[] prices1 = {1, 2, 3, 4, 5};
        System.out.println("Test case 1: Max profit = " + maxProfit(prices1)); // Expected output: 4

        // Test case 2: Prices in descending order
        int[] prices2 = {5, 4, 3, 2, 1};
        System.out.println("Test case 2: Max profit = " + maxProfit(prices2)); // Expected output: 0

    }

}
