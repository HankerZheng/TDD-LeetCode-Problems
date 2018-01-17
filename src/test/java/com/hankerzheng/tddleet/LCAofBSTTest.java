package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LCAofBSTTest {

    private LCAofBST lcAofBST;

    @Before
    public void setUp() throws Exception {
        lcAofBST = new LCAofBST();
    }

    @Test
    public void shouldPassOneNodeTest() throws Exception {
        final TreeNode root = TreeNode.constructOneNodeBST(4);
        verify(root, root, root, root);
    }

    @Test
    public void shouldPassThreeNodeTree() throws Exception {
        final TreeNode root = TreeNode.constructEasyBST();
        verify(root, root, root.left, root.right);
    }

    @Test
    public void shouldPassNormalBST() throws Exception {
        final TreeNode root = TreeNode.constructBST1();
        verify(root, root, root.left.left, root.right.right);
        verify(root.left, root, root.left.left, root.left.right);
        verify(root.right, root, root.right.left, root.right.right);
    }

    private void verify(final TreeNode expected, final TreeNode root, final TreeNode p, final TreeNode q) {
        final TreeNode actual = lcAofBST.lowestCommonAncestor(root, p, q);
        assertEquals(expected, actual);
    }
}