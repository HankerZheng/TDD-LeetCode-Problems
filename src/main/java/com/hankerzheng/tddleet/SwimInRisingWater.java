package com.hankerzheng.tddleet;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import static java.util.stream.Collectors.toList;

public class SwimInRisingWater {
    public static final int[] TRAVERSE_SEQ = {1, 0, -1, 0, 1};

    public int swimInWater(int[][] grid) {
        final ListMultimap<Integer, Integer> heightMap = ArrayListMultimap.create();
        final int length = grid.length * grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                heightMap.put(grid[i][j], i * grid[0].length + j);
            }
        }
        final UnionFind unionFind = new UnionFind(length);
        for (final Integer height: heightMap.keys().stream().sorted().collect(toList())) {
            heightMap.get(height).forEach(posi -> unionAround(posi, unionFind, grid));
            if (unionFind.find(0) == unionFind.find(length - 1)) {
                return Math.max(height, grid[0][0]);
            }
        }
        return -1;
    }

    private void unionAround(final Integer posi, final UnionFind unionFind, final int[][] grid) {
        int row = posi / grid[0].length;
        int col = posi % grid[0].length;
        for (int i = 0; i < 4; i++) {
            int newRow = row + TRAVERSE_SEQ[i];
            int newCol = col + TRAVERSE_SEQ[i + 1];
            if (isInRange(newRow, newCol, grid) && grid[newRow][newCol] < grid[row][col]) {
                unionFind.union(posi, newRow * grid[0].length + newCol);
            }
        }
    }

    private boolean isInRange(final int newRow, final int newCol, final int[][] grid) {
        return 0 <= newRow && newRow < grid.length
                && 0 <= newCol && newCol < grid[0].length;
    }
}
