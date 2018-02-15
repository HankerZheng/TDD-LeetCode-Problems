package com.hankerzheng.tddleet;

/**
 * Given an array, and a integer k,
 * sort the array with the constrain that every number can move at most k slots to its left.
 *
 *
 * Example, given [0, 4, 5, 3, 2, 1] and k = 2,
 * return [0, 3, 2, 1, 4, 5]
 *
 * for num[3] = 3, after sorting, its index should be larger than or equal to 1;
 *
 */
public class SlightlySortArray {
    /**
     * We could do it like bubble sort,
     * Every time a number is move to left, other numbers are moved to right
     */
    public void sort(final int[] nums, final int k) {
        for (int i = 0; i < nums.length; i++) {
            int currentIdx = i;
            int leftCount = 0;
            int leftIdx = i - 1;
            while (leftIdx >= 0 && leftCount < k) {
                if (nums[leftIdx] > nums[currentIdx]) {
                    swap(nums, leftIdx, currentIdx);
                    currentIdx = leftIdx;
                }
                leftCount++;
                leftIdx--;
            }
        }
    }

    private void swap(final int[] nums, final int a, final int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
