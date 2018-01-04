package com.hankerzheng.tddleet;

import java.util.PriorityQueue;

/**
 * OA from WePay
 *
 * Find the n-th smallest number that can be represented as the sum of two perfect square
 *
 * 2 = 1 + 1
 * 5 = 4 + 1
 * 8 = 4 + 4
 * 10 = 9 + 1
 * 13 = 9 + 4
 * 17 = 16 + 1
 * 18 = 9 + 9
 * 20 = 16 + 4
 * 25 = 16 + 9
 * 26 = 25 + 1
 * 29 = 25 + 4
 * 32 = 16 + 16
 * 34 = 25 + 9
 * 37 = 36 + 1
 * 40 = 36 + 4
 *
 *
 */

public class NthSumOfTwoPerfectSquare {

    /**
     * MY THOUGHTS:
     *
     * We can consider all the candidate in a triangle matrix, each candidate can be represented as one value
     * in that matrix as below
     *
     *                    ..
     *                32  ..
     *            18  25  ..
     *         8  13  20  ..
     *      2  5  10  17  ..
     *
     *  Since the numbers at row 0 must be the smallest number of that column, we could start the priority queue
     *  with these number.
     *  Once we poll one number from PQ, we push the number above into the PQ until we find the n-th number.
     *
     * @param n
     * @return
     */

    public int nthSumOfPerfectSquare(int n) {
        final PriorityQueue<TwoValueMinPQItem> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int xAxisSquare = (i + 1) * (i + 1);
            pq.add(new TwoValueMinPQItem(xAxisSquare + 1, 1));
        }
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            final TwoValueMinPQItem item = pq.poll();
            candidate = item.getLeft();
            int yAxis = item.getRight();
            int xAxisSquare = candidate - yAxis * yAxis;
            pushItemAboveInPQ(pq, xAxisSquare,  yAxis);
        }
        return candidate;
    }

    private void pushItemAboveInPQ(PriorityQueue<TwoValueMinPQItem> pq, int xAxisSquare, int yAxis) {
        int nextCandidate = xAxisSquare + (yAxis + 1) * (yAxis + 1);
        if (isNextCandidateValid(xAxisSquare, nextCandidate)) {
            pq.add(new TwoValueMinPQItem(nextCandidate, yAxis + 1));
        }
    }

    private boolean isNextCandidateValid(int xAxisSquare, int nextCandidate) {
        return nextCandidate <= xAxisSquare * 2;
    }
}
