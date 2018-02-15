package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BombEnemyTest {

    private BombEnemy bombEnemy;

    @Before
    public void setUp() throws Exception {
        bombEnemy = new BombEnemy();
    }

    @Test
    public void shouldPass1DGrid() throws Exception {
        char[][] horizonalGrid = new char[][] {
                {'W', 'E', 'E', '0', 'E' ,'W', 'E', '0'}
        };
        verify(3, horizonalGrid);

        char[][] verticalGrid = new char[][] {
                {'E'},
                {'E'},
                {'0'},
                {'E'}
        };
        verify(3, verticalGrid);
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        char[][] grid = new char[][] {
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'}
        };
        verify(3, grid);
    }

    private void verify(final int expected, final char[][] grid) {
        assertEquals(expected, bombEnemy.maxKilledEnemies(grid));
    }

}