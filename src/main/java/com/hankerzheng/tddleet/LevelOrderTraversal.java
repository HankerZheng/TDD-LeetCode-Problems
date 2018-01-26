package com.hankerzheng.tddleet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(final TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()) {
            LinkedList<TreeNode> newQueue = new LinkedList<>();
            final List<Integer> thisLevel = new ArrayList<>();
            for(TreeNode node: queue) {
                thisLevel.add(node.val);
                if (node.left != null) newQueue.addLast(node.left);
                if (node.right != null) newQueue.addLast(node.right);
            }
            result.add(thisLevel);
            queue = newQueue;
        }
        return result;

    }
}
