package com.hankerzheng.tddleet;

/**
 * 669. Trim a Binary Search Tree
 *
 *
 * Given a binary search tree and the lowest and highest boundaries as L and R,
 * trim the tree so that all its elements lies in [L, R] (R >= L).
 * You might need to change the root of the tree,
 * so the result should return the new root of the trimmed binary search tree.
 *
 * Example 1:
 * Input:
 *   1
 *  / \
 * 0   2
 *
 * L = 1
 * R = 2
 *
 * Output:
 *  1
 *   \
 *    2
 * Example 2:
 * Input:
 *   3
 *  / \
 * 0   4
 *  \
 *   2
 *  /
 * 1
 *
 * L = 1
 * R = 3
 *
 * Output:
 *      3
 *     /
 *    2
 *   /
 *  1
 *
 */
public class TrimBinaryTree {

    /**
     * MY THOUGHTS:
     *
     * Recursive call the method:
     *     If the current root is in the range, we go trim its left and right children
     *     If the current root is too large, return the trimmed left child
     *     If the current root is too small, return the trimmed right child
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root
     * @param L
     * @param R
     * @return
     *
     */

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (isRootInRange(root, L, R)) {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        } else if (root.val > R) {
            return trimBST(root.left, L, R);
        } else {
            return trimBST(root.right, L, R);
        }
    }

    private boolean isRootInRange(TreeNode root, int l, int r) {
        return l <= root.val && root.val <= r;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
