package com.hankerzheng.tddleet;


/**
 * 312. Burst Balloons
 *
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * Example:
 *
 * Given [3, 1, 5, 8]
 *
 * Return 167
 */

public class BurstBalloon {

    /**
     *
     * dp[i][j]: assume we burst the balloons from i to j without bursting other balloons,
     *           the max score we can get from them, no matter what sequence we burst them.
     *
     * Assume k is the last balloon we burst from i to j, then we have
     *
     *      dp[i][j] = max{ dp[i][k-1] + dp[k+1][j] + nums[i-1]*nums[k]*nums[j+1]} for all k belongs [i, j]
     *
     * Then the result would be, dp[0][nums.length-1]
     *
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        final int[][] maxScore = new int[nums.length][nums.length];
        for (int delta = 0; delta < nums.length; delta++) {
            for (int i = 0; i + delta < nums.length; i++) {
                int j = i + delta;
                for (int k = i; k < j + 1; k++) {
                    maxScore[i][j] = Math.max(getScoreInCondition(i, j, k, nums, maxScore), maxScore[i][j]);
                }
            }

        }
        return maxScore[0][nums.length - 1];
    }

    private int getScoreInCondition(final int i, final int j, final int k, final int[] nums, final int[][] maxScore) {
        if (i == j) {
            return getLastHitScore(nums, i, j, k);
        } else if (k == i)  {
            return getLastHitScore(nums, i, j, k) + maxScore[k+1][j];
        } else if (k == j) {
            return getLastHitScore(nums, i, j, k)+ maxScore[i][k-1];
        }
        return maxScore[i][k-1] + maxScore[k+1][j] + getLastHitScore(nums, i, j, k);
    }

    private int getLastHitScore(final int[] nums, final int i, final int j, final int k) {
        return getBalloon(nums, i - 1) * getBalloon(nums, k) * getBalloon(nums, j + 1);
    }

    private int getBalloon(final int[] nums, final int i) {
        if (0 <= i && i < nums.length) {
            return nums[i];
        } else {
            return 1;
        }
    }

}
