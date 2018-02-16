package com.hankerzheng.tddleet;

import java.util.TreeSet;

/**
 * 683. K Empty Slots
 */
public class EmptySlots {
    /**
     * O(n log n) solution
     * @param flowers
     * @param k
     * @return
     */
    public int kEmptySlots(int[] flowers, int k) {
        final TreeSet<Integer> blossoms = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            if (updateAndCheckAside(flowers[i], k, blossoms)) {
                return i + 1;
            }
        }
        return -1;
    }

    private boolean updateAndCheckAside(final int flower, final int k, final TreeSet<Integer> blossoms) {
        blossoms.add(flower);
        int leftFlower = flower - k - 1;
        int rightFlower = flower + k + 1;
        return blossoms.contains(leftFlower) && blossoms.lower(flower) == leftFlower
                || blossoms.contains(rightFlower) && blossoms.higher(flower) == rightFlower;
    }


    /**
     * O(n) solution
     *
     *
     * @param flowers
     * @param k
     * @return
     */
    public int kEmptySlotsOn(int[] flowers, int k) {
        // for each flower, record the day they bloom
        final int[] days = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            days[flowers[i] - 1] = i;
        }
        int res = Integer.MAX_VALUE;
        int curFlower = 0;
        while (curFlower + k + 1 < days.length) {
            int nextFlower = findFirstFlowerBloomBefore(days, curFlower, k);
            if (nextFlower == curFlower + k + 1) {
                res = Math.min(res, Math.max(days[curFlower], days[nextFlower]) + 1);
            }
            curFlower = nextFlower;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int findFirstFlowerBloomBefore(final int[] days, final int curFlower, final int k) {
        final int standard = Math.max(days[curFlower], days[curFlower + k + 1]);
        for (int i = curFlower + 1; i < curFlower + k + 1; i++) {
            if (days[i] < standard) {
                return i;
            }
        }
        return curFlower + k + 1;
    }
}
