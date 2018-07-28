package com.hankerzheng.tddleet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a list of TreeNode, check whether the nodes can form a tree
 */
public class TreeNodesFormATree {
    public boolean canFormTree(List<TreeNode> nodes) {
        final HashMap<TreeNode, Integer> nodeToIndex = new HashMap<>();
        final HashMap<TreeNode, TreeNode> childToParent = new HashMap<>();
        final Set<TreeNode> leaves = new HashSet<>();
        for (int i = 0; i < nodes.size(); i++) {
            final TreeNode thisNode = nodes.get(i);
            nodeToIndex.put(thisNode, i);
            if (thisNode.left == null && thisNode.right == null) {
                leaves.add(thisNode);
            }
            if (thisNode.left != null) {
                childToParent.put(thisNode.left, thisNode);
            }
            if (thisNode.right != null) {
                childToParent.put(thisNode.right, thisNode);
            }
        }
        return childToParent.size() == nodes.size() && checkValidTree(childToParent, leaves);
    }

    private boolean checkValidTree(final HashMap<TreeNode, TreeNode> childToParent, final Set<TreeNode> leaves) {
        TreeNode parentNode = null;
        for(TreeNode leaf: leaves) {
            final TreeNode thisRoot = findRoot(childToParent, leaf);
            if (parentNode == null) {
                parentNode = thisRoot;
            } else if (parentNode != thisRoot) {
                return false;
            }
        }

        return true;
    }

    private TreeNode findRoot(final HashMap<TreeNode, TreeNode> childToParent, final TreeNode leaf) {
        TreeNode curNode = leaf;
        while (childToParent.containsKey(leaf)) {
            curNode = childToParent.get(curNode);
        }
        return curNode;
    }

}
