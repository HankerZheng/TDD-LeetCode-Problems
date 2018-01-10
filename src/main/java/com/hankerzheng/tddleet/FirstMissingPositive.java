package com.hankerzheng.tddleet;

/**
 * 41. First Missing Positive*
 *
 *
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 *
 * Your algorithm should run in O(n) time and uses constant space.
 *
 */

public class FirstMissingPositive {

    /**
     * MY THOUGHTS:
     *
     * Since the range of the output should be in [1, nums.length + 1], we could use the given nums array
     * as the position to store the mark for the positive number already in the array.
     *
     * If there is no negative number in the array, we could make the -1 as the mark factor. That is, if we
     * arrived at a positive number k that is in range [1, num.length], we mark nums[k] as negative. And
     * afterwards, we could clear the mark to rearrange the input array.
     *
     * Since this problem has negative numbers in it, the -1 factor mark doesn't work here. We could move the
     * positive number to its right position to mark the visited positive number.
     *
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1), O(n) if take the given array into account
     *
     *
     * @param nums
     * @return
     */

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (isContinueSwapping(nums, i)) {
                swap(nums, i, nums[i] - 1);
            }
        }
        int result = 1;
        while (result <= nums.length && result == nums[result - 1]) {
            result ++;
        }
        return result;
    }

    private boolean isContinueSwapping(int[] nums, int i) {
        final boolean validIdx = 0 < nums[i] && nums[i] < nums.length;
        final boolean notDuplicate = validIdx && nums[i] != nums[nums[i] - 1];
        return notDuplicate;
    }

    private void swap(final int[] nums, int idx0, int idx1) {
        nums[idx0] = nums[idx0] ^ nums[idx1];
        nums[idx1] = nums[idx0] ^ nums[idx1];
        nums[idx0] = nums[idx0] ^ nums[idx1];
    }

}
