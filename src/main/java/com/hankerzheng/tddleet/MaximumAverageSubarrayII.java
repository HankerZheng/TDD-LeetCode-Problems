package com.hankerzheng.tddleet;


/**
 * 644. Maximum Average Subarray II
 *
 * Given an array consisting of n integers,
 * find the contiguous subarray whose length is greater than or equal to k that has the maximum average value.
 * And you need to output the maximum average value.
 *
 */

public class MaximumAverageSubarrayII {
    public double findMaxAverage(int[] nums, int k) {
        double left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
        double error = 1e-6;
        double sumK = 0;
        for (int i = 0; i < k; i++) {
            sumK += nums[i];
        }
        while (left + error < right) {
            double trail = (left + right) / 2;
            if (check(nums, k, trail)) {
                left = trail;
            } else {
                right = trail;
            }
        }
        return left;
    }

    /**
     * check whether there is a subarray whose length is larger than k
     * and the average is larger than trail
     *
     * Assume dp[i] is the sub-array with the largest sum and
     * whose length is larger than k and ends at index i
     *
     * then dp[i] = Math.max(dp[i - 1] + nums[i], nums[i] + ... + nums[i - k])
     *
     * @param nums
     * @param k
     * @param trail
     * @return
     */
    private boolean check(final int[] nums, final int k, final double trail) {
        double sumK = 0;
        for (int i = 0; i < k; i++) {
            sumK += nums[i] - trail;
        }
        double dp = sumK;
        double maxSum = sumK;
        for (int i = k; i < nums.length; i++) {
            sumK = sumK + nums[i] - trail - (nums[i - k] - trail);
            dp = Math.max(dp + nums[i] - trail, sumK);
            maxSum = Math.max(dp, maxSum);
        }
        return maxSum >= 0;
    }

}
