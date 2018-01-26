package com.hankerzheng.tddleet;

/**
 * 123. Best Time to Buy and Sell Stock III
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */

public class StockWithTwoTransaction {
    
    public int maxProfit(final int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        final int[] profitOne = new int[prices.length];
        final int[] profitTwo = new int[prices.length];
        int minPrices = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profitOne[i] = Math.max(profitOne[i-1], prices[i] - minPrices);
            minPrices = Math.min(minPrices, prices[i]);
        }
        int maxPrice = prices[prices.length - 1];
        int maxProfit = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            profitTwo[i] = Math.max(profitTwo[i+1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
            maxProfit = Math.max(maxProfit, profitTwo[i] + profitOne[i]);
        }
        return maxProfit;
    }
}
