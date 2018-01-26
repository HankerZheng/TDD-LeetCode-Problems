package com.hankerzheng.tddleet;

/**
 * 188. Best Time to Buy and Sell Stock IV
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 */
public class StockWithKTransactions {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        if (k >= prices.length) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1]) {
                    res += prices[i] - prices[i-1];
                }
            }
            return res;
        }
        int[][] withStock = new int[k+1][prices.length];
        withStock[0][0] = -prices[0];
        int[][] noStock = new int[k+1][prices.length];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            withStock[0][i] = Math.max(withStock[0][i-1], -prices[i]);
        }
        for (int i = 0; i <= k; i++) {
            withStock[i][0] = -prices[0];
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < prices.length; j++) {
                noStock[i][j] = Math.max(noStock[i][j-1], withStock[i-1][j-1] + prices[j]);
                withStock[i][j] = Math.max(noStock[i][j-1] - prices[j], withStock[i][j-1]);
                maxProfit = Math.max(maxProfit, noStock[i][j]);
            }
        }
        return maxProfit;
    }

}
