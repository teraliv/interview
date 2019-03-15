package com.interview.dynamic;

/**
 * 322. Coin Change
 *
 *
 * https://leetcode.com/problems/coin-change/
 * https://leetcode.com/problems/coin-change-2/
 *
 * Approach: DP - both problems
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

        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coin) {
                    if (results[j - coin] + 1 < results[j]) {
                        results[j] = 1 + results[j - coin];
                    }
                }
            }

        }

        return (results[amount] != Integer.MAX_VALUE - 1) ? results[amount] : -1;
    }


    /**
     * Finds maximum number of unique ways to make up a given amount from available coins
     *
     * @return - number of unique ways or 0.
     */
    private int uniqueCombinationsChange(int amount, int[] coins) {
        int[] results = new int[amount+1];
        results[0] = 1;

        for (int coin : coins) {
            for (int j = 1; j < results.length; j++) {
                if (j >= coin) {
                    results[j] += results[j - coin];
                }
            }
        }

        return results[amount];
    }


    public static void main(String[] args) {
        CoinChange cc = new CoinChange();

        int[] coins = {1,2,5};
        int amount = 5;

        System.out.println( cc.coinChange(coins, amount) );
        System.out.println( cc.uniqueCombinationsChange(amount, coins));
    }
}
