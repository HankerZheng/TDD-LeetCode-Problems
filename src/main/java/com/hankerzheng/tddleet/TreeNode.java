package com.hankerzheng.tddleet;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    static public TreeNode constructOneNodeBST(int val) {
        return new TreeNode(val);
    }

    static public TreeNode consturctLeftTwoNodeBST() {
        final TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        return root;
    }

    static public TreeNode consturctRightTwoNodeBST() {
        final TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        return root;
    }

    static public TreeNode constructEasyBST() {
        final TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        return root;
    }

    static public TreeNode constructBST1() {
        final TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        return root;
    }

    static public TreeNode constructBT1() {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        return root;
    }
}
