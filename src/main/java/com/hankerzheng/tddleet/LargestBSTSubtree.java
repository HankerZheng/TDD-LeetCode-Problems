package com.hankerzheng.tddleet;

/**
 * 333. Largest BST Subtree
 *
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 *
 * Note:
 * A subtree must include all of its descendants.
 * Here's an example:
 * 10
 * / \
 * 5  15
 * / \   \
 * 1   8   7
 * The Largest BST Subtree in this case is the highlighted one.
 * The return value is the subtree's size, which is 3.
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 * */
public class LargestBSTSubtree {

    static class BSTreeInfo {
        int minValue;
        int maxValue;
        boolean isBST;
        int nodeCount;

        public BSTreeInfo(final int minValue, final int maxValue, final int nodeCount) {
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.nodeCount = nodeCount;
        }
    }

    private int maxNodeCount;

    public int largestBSTSubtree(final TreeNode root) {
        maxNodeCount = 0;
        helper(root);
        return maxNodeCount;
    }

    public BSTreeInfo helper(final TreeNode node) {
        if (node == null) {
            return new BSTreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        final BSTreeInfo leftInfo = helper(node.left);
        final BSTreeInfo rightInfo = helper(node.right);
        if (isThisTreeBST(leftInfo, rightInfo, node)) {
            int thisNodeCount = leftInfo.nodeCount + rightInfo.nodeCount + 1;
            maxNodeCount = Math.max(maxNodeCount, thisNodeCount);
            return new BSTreeInfo(Math.min(leftInfo.minValue, node.val), Math.max(rightInfo.maxValue, node.val), thisNodeCount);
        }
        return null;
    }

    private boolean isThisTreeBST(final BSTreeInfo leftInfo, final BSTreeInfo rightInfo, final TreeNode node) {
        return leftInfo != null && rightInfo != null && leftInfo.maxValue < node.val && node.val < rightInfo.minValue;
    }
}
