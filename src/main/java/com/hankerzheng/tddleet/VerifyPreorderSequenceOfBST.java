package com.hankerzheng.tddleet;

import java.util.LinkedList;

/**
 * 255. Verify Preorder Sequence in Binary Search Tree
 *
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 *
 * You may assume each number in the sequence is unique.
 *
 */
public class VerifyPreorderSequenceOfBST {
    public boolean verifyPreorder(int[] preorder) {
        final LinkedList<Integer> decreasingStack = new LinkedList<>();
        int min = Integer.MIN_VALUE;
        for (int val: preorder) {
            while(!decreasingStack.isEmpty() && val > decreasingStack.peekLast()) {
                min = decreasingStack.removeLast();
            }
            if (val < min) return false;
            decreasingStack.addLast(val);
        }
        return true;
    }
}
