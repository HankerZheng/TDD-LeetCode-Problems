package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwimInRisingWaterTest {

    private SwimInRisingWater swimInRisingWater;

    @Before
    public void setUp() throws Exception {
        swimInRisingWater = new SwimInRisingWater();
    }

    @Test
    public void waitUntilWaterRiseIfOnlyOnePlace() throws Exception {
        verify(4, new int[][]{{4}});
    }

    @Test
    public void shouldPassGivenSmallExample() throws Exception {
        final int[][] grid = new int[][]{
                {0, 2},
                {1, 3}
        };
        verify(3, grid);
    }
    @Test
    public void shouldPassGivenBigExample() throws Exception {
        final int[][] grid = new int[][] {
                {0,1,2,3,4},
                {24,23,22,21,5},
                {12,13,14,15,16},
                {11,17,18,19,20},
                {10,9,8,7,6}
        };
        verify(16, grid);
    }

    private void verify(final int expected, final int[][] grid) {
        assertEquals(expected, swimInRisingWater.swimInWaterUnionFind(grid));
        assertEquals(expected, swimInRisingWater.swimInWaterBFS(grid));
    }
}