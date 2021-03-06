package com.hankerzheng.tddleet;

/**
 * 304. Range Sum Query 2D - Immutable
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1)
 * and (row2, col2) = (4, 3), which contains sum = 8.
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
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 *
 */

public class RangeSumQuery2DImmutable {

    /**
     * MY THOUGHTS:
     *
     * Create a cache matrix, which store the sum of the first k element in each row
     *
     *
     * Time Complexity: O(n)
     * Space Complexity: O(mn)
     *
     */
    int[][] sumMatrix;
    int[][] matrix;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        this.matrix = matrix;
        sumMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    sumMatrix[i][j] = matrix[i][j];
                } else {
                    sumMatrix[i][j] = matrix[i][j] + sumMatrix[i][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            result += sumMatrix[i][col2] - sumMatrix[i][col1] + matrix[i][col1];
        }
        return result;
    }
}
