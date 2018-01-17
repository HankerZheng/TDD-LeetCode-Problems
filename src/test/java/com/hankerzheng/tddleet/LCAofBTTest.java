package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LCAofBTTest {

    private LCAofBT lcAofBT;

    @Before
    public void setUp() throws Exception {
        lcAofBT = new LCAofBT();
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

    @Test
    public void shouldPassFailedTest() throws Exception {
        final TreeNode root = TreeNode.constructBT1();
        verify(root, root, root.left.right, root.right);
    }

    private void verify(final TreeNode expected, final TreeNode root, final TreeNode p, final TreeNode q) {
        final TreeNode actual = lcAofBT.lowestCommonAncestor(root, p, q);
        assertEquals(expected, actual);
    }

}