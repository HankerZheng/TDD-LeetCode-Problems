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
        final PriorityQueue<UglyNumberPQItem> pq = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) {
            pq.add( new UglyNumberPQItem(primes[i] * result[indexes[i]], i));
        }
        for (int currentIdx = 1; currentIdx < n; currentIdx++) {
            pollFromPQ(pq, currentIdx);
        }
        return result[n - 1];
    }

    private int pollFromPQ(PriorityQueue<UglyNumberPQItem> pq, int idx) {
        final UglyNumberPQItem thisItem = pq.poll();
        int thisNum = thisItem.getValue();
        result[idx] = thisNum;
        int primeIdx = thisItem.getIndex();
        while (pq.peek().getValue() <= thisNum) {
            final UglyNumberPQItem newItem = pq.poll();
            addNewToPQ(pq, newItem.getIndex());
        }
        addNewToPQ(pq, primeIdx);
        return thisNum;
    }

    private void addNewToPQ(PriorityQueue<UglyNumberPQItem> pq, int primesIdx) {
        indexes[primesIdx]++;
        int nextNum = primes[primesIdx] * result[indexes[primesIdx]];
        pq.add(new UglyNumberPQItem(nextNum, primesIdx));
    }

}
