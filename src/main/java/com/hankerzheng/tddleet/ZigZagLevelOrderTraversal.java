package com.hankerzheng.tddleet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        boolean leftRight = true;
        while(!stack.isEmpty()) {
            final LinkedList<TreeNode> newStack = new LinkedList<>();
            final List<Integer> thisRes = new ArrayList<>();
            while (!stack.isEmpty()) {
                final TreeNode thisNode = stack.removeLast();
                thisRes.add(thisNode.val);
                if (leftRight) {
                    if (thisNode.left != null) newStack.addLast(thisNode.left);
                    if (thisNode.right != null) newStack.addLast(thisNode.right);
                } else {
                    if (thisNode.right != null) newStack.addLast(thisNode.right);
                    if (thisNode.left != null) newStack.addLast(thisNode.left);
                }
            }
            stack = newStack;
            result.add(thisRes);
            leftRight ^= true;
        }
        return result;
    }
}
