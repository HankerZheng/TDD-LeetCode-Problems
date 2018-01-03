package com.hankerzheng.tddleet;

/**
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i;
 * and a non-negative integer fee representing a transaction fee.
 *
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 * You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
 *
 * Return the maximum profit you can make.
 *
 * Example 1:
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1
 * Selling at prices[3] = 8
 * Buying at prices[4] = 4
 * Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Note:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 */


public class StockWithTransactionFee {

    /**
     * MY THOUGHTS:
     *
     * Assume maxProfit[i][j] represents at day j, we have i share of the stock, the max profit we can make, then we have
     *          maxProfit[0][j] = MAX( maxProfit[0][j-1], maxProfit[1][j-1] + prices[j] - fee)
     *          maxProfit[1][j] = MAX( maxProfit[1][j-1], maxProfit[0][j-1] - prices[j])
     * Then the final result should be maxProfit[0][prices.length - 1]
     *
     * In the DP recursive equation, we can see, we only care about the profit of yesterday,
     * So, there is no need for us to store all data in the array. Only two parameter should be fine.
     *
     * Therefore, the final result would be in O(n) time, and O(1) space.
     *
     * @param prices
     * @param fee
     * @return
     */

    public int maxProfit(final int[] prices, final int fee) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }

        // the code below can be optimized, since we only use the last two state, no need to create an array to hold data
//        final int[][] maxProfit = new int[2][prices.length];
//        maxProfit[0][0] = 0;
//        maxProfit[1][0] = -prices[0];
//        for (int day = 1; day < prices.length; day++) {
//            maxProfit[0][day] = Math.max(maxProfit[0][day-1], maxProfit[1][day-1] + prices[day] - fee);
//            maxProfit[1][day] = Math.max(maxProfit[1][day-1], maxProfit[0][day-1] - prices[day]);
//        }
//        return maxProfit[0][prices.length - 1];

        int haveStock = -prices[0];
        int noStock = 0;
        for (int day = 0; day < prices.length; day++) {
            int newHaveStock = Math.max(haveStock, noStock - prices[day]);
            int newNoStock = Math.max(noStock, haveStock + prices[day] - fee);
            haveStock = newHaveStock;
            noStock = newNoStock;
        }
        return noStock;
    }

}
