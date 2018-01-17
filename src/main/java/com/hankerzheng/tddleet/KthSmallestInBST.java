package com.hankerzheng.tddleet;

/**
 * 230. Kth Smallest Element in a BST
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need
 * to find the kth smallest frequently?
 *
 * How would you optimize the kthSmallest routine?
 */

public class KthSmallestInBST {

    private Integer res;

    public int kthSmallest(TreeNode root, int k) {
        res = null;
        countAndFindKth(root, k);
        return res;
    }

    private int countAndFindKth(final TreeNode root, final int k) {
        if (res != null) {
            return -1;
        }
        if (root == null) return 0;
        int currentRank = countAndFindKth(root.left, k) + 1;
        if (currentRank == k && res == null) {
            res = root.val;
            return k;
        } else if (currentRank < k) {
            countAndFindKth(root.right, k - currentRank);
            return currentRank;
        }
        return -1;
    }
}
