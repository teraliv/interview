package com.interview.array;

/**
 * 121. Best Time to Buy and Sell Stock
 *
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class BuySellStock {

    private int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1)
            return 0;

        int buy  = prices[0];   // buy price
        int profit = 0;         // max profit

        for (int i = 1; i < prices.length; i++) {
            profit = (prices[i] - buy > profit) ? prices[i] - buy : profit; // update profit
            buy = (prices[i] < buy) ? prices[i] : buy; // update best buy price
        }

        return profit;
    }


    public static void main(String[] args) {
        BuySellStock stock = new BuySellStock();

        int[] prices1 = {7,1,5,3,6,4};  // 6 - 1
        int[] prices2 = {7,6,4,3,1};    // 0
        int[] prices3 = {2,1,2,0,1};
        int[] prices4 = {2,4,1};        // 4 - 2

        System.out.println( stock.maxProfit(prices1) );
        System.out.println( stock.maxProfit(prices2) );
        System.out.println( stock.maxProfit(prices3) );
        System.out.println( stock.maxProfit(prices4) );
    }
}
