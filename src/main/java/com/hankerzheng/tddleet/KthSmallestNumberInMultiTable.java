package com.hankerzheng.tddleet;

/**
 * 668. Kth Smallest Number in Multiplication Table
 *
 * Nearly every one have used the Multiplication Table.
 * But could you find out the k-th smallest number quickly from the multiplication table?
 *
 * Given the height m and the length n of a m * n Multiplication Table,
 * and a positive integer k,
 * you need to return the k-th smallest number in this table.
 *
 */



public class KthSmallestNumberInMultiTable {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left <= right) {
            int mid = (left + right) / 2;
            int maxRank = m * n - getNumOfLargerResult(m, n, mid);
            if (maxRank >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int getNumOfLargerResult(final int m, final int n, final int trail) {
        int largerPairCount = 0;
        for(int a = 1, b = m; a <= n; a++) {
            while (b >= 1 && a * b > trail) {
                b--;
            }
            largerPairCount += m - b;
        }
        return largerPairCount;
    }

}
