package com.hankerzheng.tddleet;

/**
 *
 * 308. Range Sum Query 2D - Mutable
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 *
 * Example:
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10
 * Note:
 * The matrix is only modifiable by the update function.
 * You may assume the number of calls to update and sumRegion function is distributed evenly.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */

public class RangeSumQuery2DMutable {

    /**
     * MY THOUGHTS:
     *
     * Same as 304, but on update, we need to update all the number after the changed one.
     *
     *
     * Time Complexity: O(n) for query and O(n) for update
     * Space Complexity: O(mn)
     */

    int[][] preSum;

    public RangeSumQuery2DMutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        this.preSum = new int[matrix.length][matrix[0].length + 1];
        for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
            for (int colIdx = 0; colIdx < matrix[0].length; colIdx++) {
                preSum[rowIdx][colIdx+1] = preSum[rowIdx][colIdx] + matrix[rowIdx][colIdx];
            }
        }

    }

    public void update(int row, int col, int val) {
        int originalVal = preSum[row][col+1] - preSum[row][col];
        int delta = val - originalVal;
        for (int colIdx = col + 1; colIdx < preSum[0].length; colIdx++) {
            preSum[row][colIdx] += delta;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int rowIdx = row1; rowIdx <= row2; rowIdx++) {
            result += preSum[rowIdx][col2+1] - preSum[rowIdx][col1];
        }
        return result;
    }
}
