package com.hankerzheng.tddleet;

/**
 * 779. K-th Symbol in Grammar
 *
 * On the first row, we write a 0.
 * Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01,
 * and each occurrence of 1 with 10.
 *
 * Given row N and index K,
 * return the K-th indexed symbol in row N.
 * (The values of K are 1-indexed.) (1 indexed).
 *
 */

public class KthSymbolGrammar {

    /**
     * It can be treated as traversing a Binary Tree, given the next move and current value
     * Determine what is the next value.
     *
     * @param n how many level we need to traverse the tree
     * @param k in which direction we should go for each level
     * @return
     */
    public int kthGrammar(int n, int k) {
        int mask = 1 << (n - 1);
        boolean curBit = false;
        while (mask != 0) {
            boolean thisBit = (mask & (k - 1)) != 0;
            curBit = curBit ^ thisBit;
            mask = mask >> 1;
        }
        return curBit ? 1 : 0;
    }
}
