package com.hankerzheng.tddleet;

public class SymmetricTree {

    static class FouraryTreeNode {
        public int val;
        public FouraryTreeNode[] children;

        public FouraryTreeNode(final int val) {
            this.val = val;
            this.children = new FouraryTreeNode[4];
        }
    }

    boolean isSymmetricTree(final FouraryTreeNode root) {
        if (root == null) {
            return true;
        }
        int left = 0, right = root.children.length;
        boolean res = true;
        while (left < right) {
            res = res && isMirrored(root.children[left], root.children[right]);
            left++;
            right--;
        }
        return res;
    }

    private boolean isMirrored(final FouraryTreeNode root1, final FouraryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        boolean res = root1.val == root2.val;
        for (int i = 0; i < root1.children.length; i++) {
            res = res && isMirrored(root1.children[i], root2.children[root1.children.length - 1 - i]);
        }
        return res;
    }
}


