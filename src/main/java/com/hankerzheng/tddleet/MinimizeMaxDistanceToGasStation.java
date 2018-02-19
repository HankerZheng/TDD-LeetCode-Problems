package com.hankerzheng.tddleet;

/**
 * 774. Minimize Max Distance to Gas Station
 *
 * On a horizontal number line, we have gas stations at positions
 * stations[0], stations[1], ..., stations[N-1], where N = stations.length.
 *
 * Now, we add K more gas stations so that D,
 * the maximum distance between adjacent gas stations, is minimized.
 *
 * Return the smallest possible value of D.
 *
 * Given [1, 3, 4] and k = 3, should return 0.5
 * should insert new station in the way of [1, *, *, 3, *, 4]
 *
 * Given [1, 3, 4] and k = 2, should return 1
 * should insert new station in the way of [1, *, 3, *, 4] or [1, *, *, 3, 4]
 *
 * Given [1, 4, 6] and k = 4, should return 1
 * should insert new station in the way of [1, *, *, 4, *, *, 6]
 *
 *
 */

public class MinimizeMaxDistanceToGasStation {
    /**
     * Binary Search
     *
     * If one problem is hard to solve and it returns a value,
     * try to write a verify function
     *
     * If the verify function takes O(n) or O(1), then we could do it in binarySearch.
     *
     * @param stations
     * @param k
     * @return
     */
    public double minmaxGasDist(int[] stations, int k) {
        double left = 0, right = stations[stations.length - 1] - stations[0], mid = right;
        double error = 1e-6;
        while (left + error < right) {
            mid = (left + right) / 2;
            int numStation = stationsNeeds(mid, stations);
            if (numStation > k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return mid;
    }

    private int stationsNeeds(final double expectedGap, final int[] stations) {
        int stationCount = 0;
        for (int i = 1; i < stations.length; i++) {
            int gap = stations[i] - stations[i-1];
            stationCount += gap / expectedGap;
        }
        return stationCount;
    }
}
