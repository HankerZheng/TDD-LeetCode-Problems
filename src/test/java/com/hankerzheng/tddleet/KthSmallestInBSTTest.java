package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KthSmallestInBSTTest {

    private KthSmallestInBST kthSmallestInBST;

    @Before
    public void setUp() throws Exception {
        kthSmallestInBST = new KthSmallestInBST();
    }

    @Test
    public void shouldPassEasyBST() throws Exception {
        final TreeNode root = TreeNode.constructEasyBST();
        verify(1, root, 1);
        verify(2, root, 2);
        verify(3, root, 3);
    }


    private void verify(final int expected, final TreeNode root, final int k) {
        assertEquals(expected, kthSmallestInBST.kthSmallest(root, k));
    }
}