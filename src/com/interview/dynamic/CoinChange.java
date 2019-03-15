package com.interview.dynamic;

/**
 * 322. Coin Change
 *
 *
 * https://leetcode.com/problems/coin-change/
 *
 * Approach: DP
 * Time complexity: O(nm) where n = number of coins, m = amount
 * Space complexity: O(m)
 */
public class CoinChange {

    /**
     * Finds fewest number of coins that makes up the amount from given coins.
     *
     * @return - number of fewest coins or -1.
     */
    private int coinChange(int[] coins, int amount) {
        int[] results = new int[amount + 1];

        for (int i = 1; i < results.length; i++)
            results[i] = Integer.MAX_VALUE-1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int coin = coins[i];

                if (j >= coin) {
                    if (results[j - coin] + 1 < results[j]) {
                        results[j] = 1 + results[j - coin];
                    }
                }
            }

        }

        return (results[amount] != Integer.MAX_VALUE - 1) ? results[amount] : -1;
    }



    public static void main(String[] args) {
        CoinChange cc = new CoinChange();

        int[] coins = {300};
        int amount = 100;

        System.out.println( cc.coinChange(coins, amount) );
    }
}
