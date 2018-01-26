package com.hankerzheng.tddleet;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of
 * the stock multiple times) with the following restrictions:
 *
 * 1. You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 2. After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 *
 *
 * Example:
 *
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 * Credits:
 * Special thanks to @dietpepsi for adding this problem and creating all test cases.
 *
 *
 */
public class StockWithCoolDown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        final int[][] maxProfit = new int[3][prices.length];
        int res = Math.max(prices[1] - prices[0], 0);
        maxProfit[1][0] = - prices[0];
        maxProfit[1][1] = - Math.min(prices[0], prices[1]);
        for (int i = 2; i < prices.length; i++) {
            maxProfit[0][i] = Math.max(maxProfit[2][i-1], maxProfit[0][i-1]);
            maxProfit[1][i] = Math.max(Math.max(maxProfit[2][i-1], maxProfit[0][i-1]) - prices[i], maxProfit[1][i-1]);
            maxProfit[2][i] = maxProfit[1][i-2] + prices[i-1];
            res = Math.max(Math.max(maxProfit[0][i], maxProfit[2][i]), maxProfit[1][i-1] + prices[i]);
        }
        return res;
    }
}
