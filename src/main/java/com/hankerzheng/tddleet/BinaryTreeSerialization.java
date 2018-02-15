package com.hankerzheng.tddleet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 297. Serialize and Deserialize Binary Tree
 */

public class BinaryTreeSerialization {

    public TreeNode deserialize(final Integer... nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }

        int index = 1;
        final LinkedList<TreeNode> pendingNodes = new LinkedList<>();
        final TreeNode rootNode = new TreeNode(nodes[0]);
        pendingNodes.addLast(rootNode);
        while (index < nodes.length) {
            final TreeNode thisNode = pendingNodes.removeFirst();
            thisNode.left = constructNode(nodes, index);
            if (thisNode.left != null) {
                pendingNodes.addLast(thisNode.left);
            }
            thisNode.right = constructNode(nodes, index + 1);
            if (thisNode.right != null) {
                pendingNodes.addLast(thisNode.right);
            }
            index += 2;
        }
        return rootNode;
    }


    public List<Integer> serialize(final TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        final LinkedList<TreeNode> queue = new LinkedList<>();
        int nullTillEndIdx = 1;
        queue.addLast(root);
        while (shouldContinue(queue, nullTillEndIdx)) {
            final TreeNode thisNode = queue.removeFirst();
            nullTillEndIdx--;
            if (thisNode != null) {
                res.add(thisNode.val);
                nullTillEndIdx = updateQueueAndCheckNull(thisNode, queue, nullTillEndIdx);
            } else {
                res.add(null);
            }
        }
        return res;
    }


    private TreeNode constructNode(final Integer[] nodes, final int index) {
        if (index >= nodes.length || nodes[index] == null) {
            return null;
        }
        return new TreeNode(nodes[index]);
    }

    private int updateQueueAndCheckNull(final TreeNode thisNode, final LinkedList<TreeNode> queue, final int nullTillEndIdx) {
        int res = nullTillEndIdx;
        queue.addLast(thisNode.left);
        if (thisNode.left != null) {
            res = queue.size();
        }
        queue.addLast(thisNode.right);
        if (thisNode.right != null) {
            res = queue.size();
        }
        return res;
    }

    private boolean shouldContinue(final LinkedList<TreeNode> queue, final int nullTillEndIdx) {
        return !queue.isEmpty() && nullTillEndIdx != 0;
    }

}

