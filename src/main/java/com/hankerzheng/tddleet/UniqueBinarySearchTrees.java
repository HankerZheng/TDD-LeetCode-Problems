package com.hankerzheng.tddleet;

/**
 * 96. Unique Binary Search Trees
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 *
 *
 **/

public class UniqueBinarySearchTrees {

    /**
     * MY THOUGHTS:
     *
     * Given number n, we have n candidates for the root node. Assume we pick k as the root number,
     * then the left subtree would have (k - 1) nodes, and the right subtree would have (n - k - 1) nodes
     *
     * Thus, given root as k, there would be numTree(k-1) * numTree(n-k-1).
     * Then we only need to add all the result of different root choices.
     *
     *
     * Time Complexity: O(n2)
     * Space Complexity: O(n)
     *
     * @param n
     * @return
     */

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        final int[] results = new int[n + 1];
        results[0] = 1;
        for (int i = 1; i <= n; i++) {
            results[i] = getResult(results, i);
        }
        return results[n];
    }

    private int getResult(int[] results, int index) {
        int thisRes = 0;
        for (int j = 0; j < index; j++) {
            thisRes += results[j] * results[index - j - 1];
        }
        return thisRes;
    }


}
