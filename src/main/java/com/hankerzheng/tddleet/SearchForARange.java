package com.hankerzheng.tddleet;

public class SearchForARange {

    public int[] searchRange(int[] nums, int target) {
        int leftIndex = searchLeftMost(nums, target);
        if (0 <= leftIndex && leftIndex < nums.length && nums[leftIndex] == target) {
            return new int[]{leftIndex, searchRightMost(nums, target)};
        }
        return new int[]{-1, -1};
    }

    private int searchRightMost(final int[] nums, final int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private int searchLeftMost(final int[] nums, final int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
