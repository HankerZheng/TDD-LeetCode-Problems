package com.hankerzheng.tddleet;




import java.util.PriorityQueue;

/**
 * 313. Super Ugly Number
 *
 * Write a program to find the nth super ugly number.
 *
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 *
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 *
 * Credits:
 * Special thanks to @dietpepsi for adding this problem and creating all test cases.
 */


public class SuperUglyNumber {

    /**
     * MY THOUGHTS:
     *
     * If we find the first k ugly number, then next k + 1 ugly number must be one of the already-found ugly
     * number times the given primes. Thus, we can use a Priority Queue to store all the candidate.
     *
     * In order to keep the size of Priority Queue steady, for each prime, we should know with which ugly number
     * it has been multiplied. For example, given primes as [5,7,11], we have the indexes array as [0, 0, 0], and
     * result array as [1, ... ].
     *
     * Candidates for the 2nd ugly number would be MIN(5 * result[0], 7 * result[0], 11 * result[0]). Apparently, 5
     * is the smallest number in the PQ. We add 5 into the result list and increase the indexes array of 5 by 1.
     * Then we have:
     *      result: [1, 5, ...]
     *      indexes: [1, 0, 0]
     *
     * Now, the candidates could be [5 * result[1], 7 * result[0], 8 * result[0]], where  7 is next ugly number.
     *                              [   25,             7,              8       ]
     * Then, the arrays would be updated to
     *      result: [1, 5, 7, ...]
     *      indexes: [1, 1, 0]
     *      candidates: [25 (5 * 5), 35 (7 * 5), 11 (11 * 1)]
     *
     * The next step would be
     *      result: [1, 5 ,7, 11, ...]
     *      indexes: [1, 1, 1]
     *      indexes: [25, 35, 55 (11 * 5)]
     *
     * So on so forth, we can finally get the K-th ugly number.
     *
     *
     *
     * Note: there would be duplicate number in the PQ, so every time when we poll something from the PQ, we also
     *       need to check whether the next largest is equal to the first one. If true, poll that out, too.
     *
     */


    private int[] primes;
    private int[] indexes;
    private int[] result;

    public int nthSuperUglyNumber(int n, int[] primes) {

        if (primes.length == 1) {
            return (int) Math.pow(primes[0], n);
        }
        this.primes = primes;
        this.indexes = new int[primes.length];
        this.result = new int[n];
        result[0] = 1;
        final PriorityQueue<TwoValueMinPQItem> pq = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) {
            pq.add( new TwoValueMinPQItem(primes[i] * result[indexes[i]], i));
        }
        for (int currentIdx = 1; currentIdx < n; currentIdx++) {
            pollFromPQ(pq, currentIdx);
        }
        return result[n - 1];
    }

    private void pollFromPQ(PriorityQueue<TwoValueMinPQItem> pq, int idx) {
        final TwoValueMinPQItem thisItem = pq.poll();
        int thisNum = thisItem.getLeft();
        result[idx] = thisNum;
        int primeIdx = thisItem.getRight();
        while (pq.peek().getLeft() <= thisNum) {
            final TwoValueMinPQItem newItem = pq.poll();
            addNewToPQ(pq, newItem.getRight());
        }
        addNewToPQ(pq, primeIdx);
    }

    private void addNewToPQ(PriorityQueue<TwoValueMinPQItem> pq, int primesIdx) {
        indexes[primesIdx]++;
        int nextNum = primes[primesIdx] * result[indexes[primesIdx]];
        pq.add(new TwoValueMinPQItem(nextNum, primesIdx));
    }

}
