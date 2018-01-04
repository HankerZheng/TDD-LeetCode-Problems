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
 *
 */

public class NthSumOfTwoPerfectSquare {

    public int nthSumOfPerfectSquare(int n) {
        final PriorityQueue<TwoValueMinPQItem> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new TwoValueMinPQItem((i + 1) * (i + 1) + 1, 1));
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            final TwoValueMinPQItem item = pq.poll();
            ans = item.getValue();
            int index = item.getIndex();
            int base = ans - index * index;
            item.setValue(ans + 2 * index + 1);
            item.setIndex(index + 1);
            if (item.getValue() <= base * 2) {
                pq.add(item);
            }
        }
        return ans;
    }
}