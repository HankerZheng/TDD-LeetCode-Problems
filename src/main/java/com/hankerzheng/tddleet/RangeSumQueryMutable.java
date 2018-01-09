package com.hankerzheng.tddleet;

/**
 * 307. Range Sum Query - Mutable
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 */
public class RangeSumQueryMutable {

    /**
     * MY THOUGHTS:
     *
     * <a href="https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/">Binary Indexed Tree</a>
     *
     *
     * @param nums
     */

    private BinaryIndexedTree binaryIndexedTree;

    public RangeSumQueryMutable(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        binaryIndexedTree = new BinaryIndexedTree(nums);
    }

    public void update(int i, int val) {

    }

    public int sumRange(int i, int j) {
        return -1;
    }
}
