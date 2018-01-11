package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestUnivaluePathTest {

    private LongestUnivaluePath longestUnivaluePath;

    @Before
    public void setUp() throws Exception {
        longestUnivaluePath = new LongestUnivaluePath();
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        final LongestUnivaluePath.TreeNode root = constructGivenExample00();
        verify(root, 2);
    }

    private LongestUnivaluePath.TreeNode constructGivenExample00() {
        final LongestUnivaluePath.TreeNode root = new LongestUnivaluePath.TreeNode(5);
        root.left = new LongestUnivaluePath.TreeNode(4);
        root.right = new LongestUnivaluePath.TreeNode(5);
        root.left.left = new LongestUnivaluePath.TreeNode(4);
        root.left.right = new LongestUnivaluePath.TreeNode(4);
        root.right.right = new LongestUnivaluePath.TreeNode(4);
        return root;
    }

    private void verify(LongestUnivaluePath.TreeNode root, int expected) {
        assertEquals(expected, longestUnivaluePath.longestUnivaluePath(root));
    }


}