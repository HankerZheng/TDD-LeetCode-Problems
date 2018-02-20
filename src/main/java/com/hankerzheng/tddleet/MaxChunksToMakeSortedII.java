package com.hankerzheng.tddleet;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 768. Max Chunks To Make Sorted II
 *
 * Given an array arr of integers (not necessarily distinct),
 * we split the array into some number of "chunks" (partitions),
 * and individually sort each chunk.
 *
 * After concatenating them, the result equals the sorted array.
 *
 * What is the most number of chunks we could have made?
 */
public class MaxChunksToMakeSortedII {

    /**
     * At the position where a chunk ends, we must be able to state that
     * we have visited all the number that is smaller than the Max number
     * we have traversed.
     *
     */
    public int maxChunksToSorted(int[] arr) {
        final TreeMap<Integer, Integer> numbersBehind = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            numbersBehind.put(arr[i], numbersBehind.getOrDefault(arr[i], 0) + 1);
        }

        int curMax = arr[0], chunkCount = 0;
        for (int i = 0; i < arr.length; i++) {
            curMax = Math.max(curMax, arr[i]);
            updateNumbersBehind(numbersBehind, arr[i]);
            if (numbersBehind.isEmpty() || numbersBehind.firstKey() >= curMax) {
                chunkCount += 1;
            }
        }
        return chunkCount;
    }

    /**
     *
     * @param arr
     * @return
     */
    public int maxChunksToSortedWithoutTree(int[] arr) {
        final int[] maxBefore = arr.clone();
        Arrays.sort(maxBefore);
        int chunkCount = 0;
        for (int i = 1; i < arr.length; i++) {
            maxBefore[i] = Math.max(maxBefore[i - 1], arr[i - 1]);
        }

        int smallestNumber = arr[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            int idx = arr.length - 1- i;
            smallestNumber = Math.min(smallestNumber, arr[idx]);
            if (smallestNumber >= maxBefore[idx]) {
                chunkCount += 1;
            }
        }
        return chunkCount;
    }

    private void updateNumbersBehind(final TreeMap<Integer, Integer> numbersBehind, final int num) {
        numbersBehind.put(num, numbersBehind.get(num) - 1);
        if (numbersBehind.get(num) == 0) {
            numbersBehind.remove(num);
        }
    }

}
