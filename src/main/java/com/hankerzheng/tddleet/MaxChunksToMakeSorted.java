package com.hankerzheng.tddleet;

/**
 * 769. Max Chunks To Make Sorted
 *
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1],
 * we split the array into some number of "chunks" (partitions),
 * and individually sort each chunk.
 *
 * After concatenating them, the result equals the sorted array.
 * What is the most number of chunks we could have made?
 *
 */
public class MaxChunksToMakeSorted {
    /**
     * A chunk must cover the head and the max number start at the head and all missing number in middle
     *
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int curMax = 0, curHead = 0, chunkCount = 0;
        boolean foundHead = false;
        for (int i = 0; i < arr.length; i++) {
            curMax = Math.max(curMax, arr[i]);
            if (arr[i] == curHead) {
                foundHead = true;
            }
            if (foundHead && curMax == i) {
                curHead = curMax + 1;
                foundHead = false;
                chunkCount++;
            }
        }
        return chunkCount;
    }
}
