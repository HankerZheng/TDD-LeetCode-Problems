package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinaryTreeSerializationTest {

    private BinaryTreeSerialization binaryTreeSerialization;

    @Before
    public void setUp() throws Exception {
        binaryTreeSerialization = new BinaryTreeSerialization();
    }

    @Test
    public void shouldSerializeSimpleTree() throws Exception {
        final TreeNode root = constructSimpleTree();
        verifySerialize(root, 1, 2, 3);
    }

    @Test
    public void shouldSerializeTreeWithNull() throws Exception {
        final TreeNode root = constructSimpleTree();
        root.left = null;
        verifySerialize(root, 1, null, 3);
    }

    @Test
    public void shouldSerializeUncompleteTree() throws Exception {
        final TreeNode root = constructSimpleTree();
        root.right = null;
        verifySerialize(root, 1, 2);
    }

    @Test
    public void shouldDeserializeSimpleTree() throws Exception {
        final TreeNode expectedRoot = constructSimpleTree();
        verifyDeserialize(expectedRoot, 1, 2, 3);
    }

    @Test
    public void shouldDeserializeTreeWithNull() throws Exception {
        final TreeNode expectedRoot = constructSimpleTree();
        expectedRoot.left = null;
        verifyDeserialize(expectedRoot, 1, null, 3);
    }

    @Test
    public void shouldDeserializeUncompleteTree() throws Exception {
        final TreeNode expectedRoot = constructSimpleTree();
        expectedRoot.right = null;
        verifyDeserialize(expectedRoot, 1, 2);
    }

    @Test
    public void shouldPassMixOperations() throws Exception {
        final Integer[] case1 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        verifyDeserialize(binaryTreeSerialization.deserialize(case1), case1);

        final Integer[] case2 = new Integer[]{1, 2, null, 3, 4, null, null, 5};
        verifyDeserialize(binaryTreeSerialization.deserialize(case2), case2);

        final Integer[] case3 = new Integer[]{1, null, 2, null, 3, null, 4, null, 5};
        verifyDeserialize(binaryTreeSerialization.deserialize(case3), case3);
    }


    private void verifyDeserialize(final TreeNode expectedRoot, final Integer... nodes) {
        verifyTree(expectedRoot, binaryTreeSerialization.deserialize(nodes));
    }

    private void verifyTree(final TreeNode expectedNode, final TreeNode actualNode) {
        if (expectedNode != null && actualNode != null) {
            assertEquals(expectedNode.val, actualNode.val);
            verifyTree(expectedNode.left, actualNode.left);
            verifyTree(expectedNode.right, actualNode.right);
        } else {
            assertEquals(expectedNode, actualNode);
        }
    }

    private TreeNode constructSimpleTree() {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        return root;
    }

    private void verifySerialize(final TreeNode root, final Integer... expected) {
        List<Integer> actual = binaryTreeSerialization.serialize(root);
        assertEquals(expected.length, actual.size());
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual.get(i));
        }
    }

}
