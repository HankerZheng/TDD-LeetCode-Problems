package com.hankerzheng.tddleet;

/**
 * 666. Path Sum IV
 *
 * If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.
 *
 * For each integer in this list:
 *
 *     1. The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 *     2. The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8.
 *        The position is the same as that in a full binary tree.
 *     3. The units digit represents the value V of this node, 0 <= V <= 9.
 *
 * Given a list of ascending three-digits integers representing a binary with the depth smaller than 5.
 * You need to return the sum of all paths from the root towards the leaves.
 *
 */

public class PathSumIV {

    public int pathSum(int[] nums) {
        final int[] data = new int[15];
        for (int i = 0; i < data.length; i++) {
            data[i] = -1;
        }
        for (int num: nums) {
            int curIdx = getCurIndex(num / 10);
            data[curIdx] = num % 10;
        }
        int res = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != -1 && !isNotLeaf(data, i)) {
                res += getPathSumOfLeaf(data, i);
            }
        }
        return res;
    }

    private int getPathSumOfLeaf(final int[] data, final int i) {
        int res = 0;
        int curIdx = i;
        while (curIdx != 0) {
            res +=  data[curIdx];
            curIdx = getParentIdx(curIdx);
        }
        return res + data[0];

    }

    private int getParentIdx(final int curIdx) {
        return (curIdx - 1) / 2;
    }

    private boolean isNotLeaf(final int[] data, final int i) {
        int leftIdx = (i + 1) * 2 - 1;
        int rightIdx = leftIdx + 1;
        boolean hasLeft = leftIdx < data.length && data[leftIdx] != -1;
        boolean hasRight = rightIdx < data.length && data[rightIdx] != -1;
        return hasLeft || hasRight;

    }


    private int getCurIndex(final int position) {
        return (1 << (position / 10 - 1)) + position % 10 - 2;
    }


}
