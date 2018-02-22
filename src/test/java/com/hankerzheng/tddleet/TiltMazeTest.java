package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TiltMazeTest {

    private TiltMaze solution;

    @Before
    public void setUp() throws Exception {
        solution = new TiltMaze();
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        final int[][] maze = new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0}
        };
        verify("ul", maze, new int[]{4, 3}, new int[]{0, 1});
        verify("impossible!", maze, new int[]{4, 3}, new int[]{3, 0});
    }

    private void verify(final String expected, final int[][] maze, final int[] start, final int[] end) {
        assertEquals(expected, solution.findShortestWay(maze, start, end));
    }
}