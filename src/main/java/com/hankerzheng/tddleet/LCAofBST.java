package com.hankerzheng.tddleet;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Given a binary search tree, find the lowest common ancestor of two given nodes in the tree.
 *
 */

public class LCAofBST {
    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        int minValue = Math.min(p.val, q.val);
        int maxValue = Math.max(p.val, q.val);
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.val >= minValue && currentNode.val <= maxValue) {
                return  currentNode;
            } else if (currentNode.val > maxValue) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return null;
    }
}
