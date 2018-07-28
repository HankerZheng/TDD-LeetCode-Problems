package com.hankerzheng.tddleet;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * 778. Swim in Rising Water
 *
 * On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).
 *
 * Now rain starts to fall.
 * At time t, the depth of the water everywhere is t.
 * You can swim from a square to another 4-directionally adjacent square
 * if and only if the elevation of both squares individually are at most t.
 * You can swim infinite distance in zero time.
 * Of course, you must stay within the boundaries of the grid during your swim.
 *
 * You start at the top left square (0, 0).
 * What is the least time until you can reach the bottom right square (N-1, N-1)?
 */
public class SwimInRisingWater {
    public static final int[] TRAVERSE_SEQ = {1, 0, -1, 0, 1};

    /**
     * Solution with UnionFind and Multimap
     * @param grid
     * @return
     */
    public int swimInWaterUnionFind(int[][] grid) {
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


    /**
     * Solution with BFS on Priority Queue
     * @param grid
     * @return
     */
    public int swimInWaterBFS(final int[][] grid) {
        final int width = grid[0].length;
        final PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (grid[a/width][a%width] - grid[b/width][b%width]));
        final Set<Integer> visited = new HashSet<>();
        int time = 0;
        pq.add(0);
        while (!pq.isEmpty()) {
            final Integer lowestAvailable = pq.remove();
            if (visited.contains(lowestAvailable)) {
                continue;
            }
            final int row = lowestAvailable / width;
            final int col = lowestAvailable % width;
            time = Math.max(time, grid[row][col]);
            visited.add(row * width + col);
            if (row == grid.length - 1 && col == width - 1) {
                return Math.max(time, grid[row][col]);
            }
            for (int i = 0; i < 4; i++) {
                int newRow = row + TRAVERSE_SEQ[i];
                int newCol = col + TRAVERSE_SEQ[i + 1];
                if (isInRange(newRow, newCol, grid) && !visited.contains(newRow * width + newCol)) {
                    pq.add(newRow * width + newCol);
                }
            }
        }
        return time;
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
