package com.hankerzheng.tddleet;

/**
 * 361. Bomb Enemy
 *
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
 * return the maximum enemies you can kill using one bomb.
 *
 * The bomb kills all the enemies in the same row and column from the planted point until it hits
 * the wall since the wall is too strong to be destroyed.
 *
 * Note that you can only put the bomb at an empty cell.
 *
 *
 * Example:
 * For the given grid
 *
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 *
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 *
 */


public class BombEnemy {

    /**
     *
     * Every time when we hit a wall, it is time for us to calculate the enemies bombed after that wall
     * Otherwise, we can use the enemyCnt pre-calculated.
     *
     */
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        int enemyInRow = 0;
        int[] enemyInCol = new int[grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (col == 0 || grid[row][col] == 'W') {
                    enemyInRow = killEnemiesInRow(grid, row, col);
                }
                if (row == 0 || grid[row][col] == 'W') {
                    enemyInCol[col] = killEnemiesInCol(grid, row, col);
                }
                if (grid[row][col] == '0') {
                    res = Math.max(res, enemyInRow + enemyInCol[col]);
                }
            }
        }
        return res;
    }

    private int killEnemiesInCol(final char[][] grid, final int row, final int col) {
        int enemyCnt = grid[row][col] == 'E' ? 1 : 0;
        for (int rowIdx = row + 1; rowIdx < grid.length; rowIdx++) {
            if (grid[rowIdx][col] == 'E') {
                enemyCnt += 1;
            } else if (grid[rowIdx][col] == 'W') {
                break;
            }
        }
        return enemyCnt;
    }

    private int killEnemiesInRow(final char[][] grid, final int row, final int col) {
        int enemyCnt = grid[row][col] == 'E' ? 1 : 0;
        for (int colIdx = col + 1; colIdx < grid[0].length; colIdx++) {
            if (grid[row][colIdx] == 'E') {
                enemyCnt += 1;
            } else if (grid[row][colIdx] == 'W') {
                break;
            }
        }
        return enemyCnt;
    }
}
