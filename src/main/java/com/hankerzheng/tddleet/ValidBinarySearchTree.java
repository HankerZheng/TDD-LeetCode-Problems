package com.hankerzheng.tddleet;

import java.util.LinkedList;

/**
 * 98. Validate Binary Search Tree
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 *   The left subtree of a node contains only nodes with keys less than the node's key.
 *   The right subtree of a node contains only nodes with keys greater than the node's key.
 *   Both the left and right subtrees must also be binary search trees.
 *
 */

public class ValidBinarySearchTree {

    /**
     * Recursive solution.
     *
     * Given the range of the child node, check both the children.
     *
     * @param root
     * @return
     */
    public boolean isValidBSTRecursive(final TreeNode root) {
        if (root == null) {
            return true;
        }
        return isChildNodeBST(root.left, null, root.val) && isChildNodeBST(root.right, root.val, null);
    }

    private boolean isChildNodeBST(final TreeNode node, final Integer minValue, final Integer maxValue) {
        if (node == null) {
            return true;
        }
        if (isInNodeInRange(minValue, maxValue, node)) {
            return isChildNodeBST(node.left, minValue, node.val)
                    && isChildNodeBST(node.right, node.val, maxValue);
        }
        return false;
    }

    private boolean isInNodeInRange(final Integer minValue, final Integer maxValue, final TreeNode node) {
        return (minValue == null || node.val > minValue) && (maxValue == null || node.val < maxValue) ;
    }


    /**
     * Iterative solution.
     *
     * Do in-order traverse, and check whether the output is in ascending order.
     *
     * @param root
     * @return
     */
    public boolean isValidBSTIterative(final TreeNode root) {
        if (root == null)  return true;
        final LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        TreeNode leftMostNode = root.left;
        Integer prevValue = null;
        while (leftMostNode != null || !stack.isEmpty()) {
            while (leftMostNode != null) {
                stack.addLast(leftMostNode);
                leftMostNode = leftMostNode.left;
            }
            leftMostNode = stack.removeLast();
            if (prevValue != null && prevValue >= leftMostNode.val) {
                return false;
            }
            prevValue = leftMostNode.val;
            leftMostNode = leftMostNode.right;
        }
        return true;
    }
}
