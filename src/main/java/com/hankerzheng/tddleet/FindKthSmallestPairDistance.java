package com.hankerzheng.tddleet;

import java.util.Arrays;

/**
 * 719. Find K-th Smallest Pair Distance
 *
 * Given an integer array,
 * return the k-th smallest distance among all the pairs.
 * The distance of a pair (A, B) is defined as the absolute difference between A and B.
 *
 */
public class FindKthSmallestPairDistance {

    /**
     * Same solution as 774. Minimize Max Distance to Gas Station
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1];
        int totalPair = nums.length * (nums.length - 1) / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int maxRank = totalPair - getNumOfLargePairs(nums, mid);
            if (maxRank >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

    private int getNumOfLargePairs(final int[] nums, final int trial) {
        int largerPair = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            int smaller = nums[i];
            while (j < nums.length && nums[j] - smaller <= trial) {
                j++;
            }
            largerPair += nums.length - j;
        }
        return largerPair;
    }
}
