package com.hankerzheng.tddleet;

/**
 * 152. Maximum Product Subarray
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 *
 */

public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        int oldMax = 1;
        int oldMin = 1;
        for (final int num: nums) {
            int curMax = Math.max(Math.max(oldMax * num, oldMin * num), num);
            int curMin = Math.min(Math.min(oldMax * num, oldMin * num), num);
            max = Math.max(curMax, max);
            oldMax = curMax;
            oldMin = curMin;
        }
        return max;
    }
}
