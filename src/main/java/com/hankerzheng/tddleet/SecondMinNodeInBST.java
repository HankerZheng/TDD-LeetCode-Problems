package com.hankerzheng.tddleet;

/**
 * 671. Second Minimum Node In a Binary Tree
 * <p>
 * <p>
 * Given a non-empty special binary tree consisting of nodes with the non-negative value,
 * where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes,
 * then this node's value is the smaller value among its two sub-nodes.
 * <p>
 * Given such a binary tree, you need to output the second minimum value in
 * the set made of all the nodes' value in the whole tree.
 * <p>
 * If no such second minimum value exists, output -1 instead.
 * <p>
 * Example 1:
 * Input:
 * 2
 * / \
 * 2   5
 * / \
 * 5   7
 * <p>
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * Example 2:
 * Input:
 * 2
 * / \
 * 2   2
 * <p>
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 */

public class SecondMinNodeInBST {

    /**
     * MY THOUGHTS:
     *
     * Given a such tree, the root node of the tree must be the min value of that tree.
     * Thus, we could pass the root.val, the min value of the tree, into the recursive
     * method to find the second min value.
     *
     *
     * Time Complexity: O(n)
     * SpaceComplexity: O(log n), the heap size
     *
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        return findMinExcept(root, root.val);
    }

    private int findMinExcept(final TreeNode root, final int minVal) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return root.val == minVal ? -1 : root.val;
        if (root.val > minVal) return root.val;
        int leftVal = findMinExcept(root.left, minVal);
        int rightVal = findMinExcept(root.right, minVal);
        return leftVal == -1 ? rightVal : rightVal == -1 ? leftVal : Math.min(leftVal, rightVal);
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
