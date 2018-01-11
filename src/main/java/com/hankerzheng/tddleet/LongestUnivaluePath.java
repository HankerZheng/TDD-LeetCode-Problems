package com.hankerzheng.tddleet;

/**
 * 687. Longest Univalue Path
 *
 * Given a binary tree, find the length of the longest path where each node in the path has the same value.
 * This path may or may not pass through the root.
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * Example 1:
 *
 * Input:
 *
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * Output:
 *
 * 2
 * Example 2:
 *
 * Input:
 *
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * Output:
 *
 * 2
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 * *
 * */

public class LongestUnivaluePath {
    private int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        longestPathFromRoot(root);
        return res;
    }

    private int longestPathFromRoot(TreeNode node) {
        if (node == null) {
            return 0;
        }
        final int leftPath = longestPathFromRoot(node.left);
        final int rightPath = longestPathFromRoot(node.right);
        if (matchLeft(node) && matchRight(node)) {
            res = Math.max(res, leftPath + rightPath + 2);
            return Math.max(leftPath, rightPath) + 1;
        } else if (matchLeft(node)) {
            res = Math.max(res, leftPath + 1);
            return leftPath + 1;
        } else if (matchRight(node)) {
            res = Math.max(res, rightPath + 1);
            return rightPath + 1;
        } else {
            return 0;
        }
    }

    private boolean matchLeft(final TreeNode node) {
        return node.left != null && node.left.val == node.val;
    }

    private boolean matchRight(final TreeNode node) {
        return node.right != null && node.right.val == node.val;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
