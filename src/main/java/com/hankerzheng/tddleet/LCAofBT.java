package com.hankerzheng.tddleet;

import java.util.LinkedList;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given a binary tree, find the lowest common ancestor of two given nodes in the tree.
 *
 */

public class LCAofBT {

    /**
     * MY THOUGHTS:
     *
     * Iterative Solution:  can handle the case when p == q
     *
     *      In-Order traverse the tree, and maintain a parentStack, which store all
     *      the parents of the current node.
     *
     *      Once we find the matching node first time, we mark a potentialAns in the
     *      current parentStack. Then, the final answer could only be the node in the
     *      parentStack, that is, all the parent of the current matching node.
     *      
     *      Keep traversing and update the potentialAns. The updating of potentialAns
     *      could only move up never down.
     *
     *      Once we find the other matching node, just return the potentialAns
     *
     *
     * Recursive Solution:  can handle the case when p == q
     *
     *      Recursively call `lowestCommonAncestor` on the child of currentNode
     *      If no matching node found in the current root, return null
     *      If any matching node found in the current root, return currentNode
     *
     *      Then we can have the result of these two method calls:
     *      `lca(root.left, p, q)` and `lca(root.right, p, q)`
     *
     *      If one of them is null, return the other ans
     *      If both of then is non-null, return the current root.
     *
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        final LinkedList<TreeNode> stack = new LinkedList<>();
        final LinkedList<TreeNode> parentStack = new LinkedList<>();
        TreeNode potentialNode = null;
        int matchingStatus = 0;
        stack.addLast(root);
        while (!stack.isEmpty()) {
            final TreeNode thisNode = stack.removeLast();
            if (isChildOfCurrentParent(parentStack, thisNode)) {
                parentStack.addLast(thisNode);
            } else {
                potentialNode = updateParentStackAndPotentialNode(thisNode, parentStack, potentialNode);
                parentStack.addLast(thisNode);
            }
            if (isMatchingNode(thisNode, p, q)) {
                matchingStatus ++;
            }
            if (matchingStatus == 1) {
                potentialNode = parentStack.getLast();
                matchingStatus ++;
            }
            if (matchingStatus == 3) {
                return potentialNode;
            }
            if (thisNode.right != null) stack.addLast(thisNode.right);
            if (thisNode.left != null) stack.addLast(thisNode.left);
        }
        return potentialNode;
    }

    private TreeNode updateParentStackAndPotentialNode(final TreeNode node, final LinkedList<TreeNode> parentStack, final TreeNode potentialNode) {
        TreeNode currentPotential = potentialNode;
        while (!isChildOfCurrentParent(parentStack, node)) {
            final TreeNode removedParent = parentStack.removeLast();
            if (removedParent == currentPotential) {
                currentPotential = parentStack.getLast();
            }
        }
        return currentPotential;
    }

    private boolean isMatchingNode(final TreeNode thisNode, final TreeNode p, final TreeNode q) {
        return thisNode == p || thisNode == q;
    }

    private boolean isChildOfCurrentParent(final LinkedList<TreeNode> parentStack, final TreeNode thisNode) {
        return parentStack.isEmpty() || parentStack.getLast().left == thisNode || parentStack.getLast().right == thisNode;
    }
}
