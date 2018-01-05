package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RangeSumQuery2DImmutableTest {

    private RangeSumQuery2DImmutable rangeSumQuery2DImmutable;


    @Test
    public void shouldPassGivenExample() throws Exception {
        testMatrix0();
        verify(8, 2, 1, 4, 3);
        verify(11, 1, 1, 2, 2);
        verify(12, 1, 2, 2, 4);
    }


    private void verify(final int expected, int row1, int col1, int row2, int col2) {
        assertEquals(expected, rangeSumQuery2DImmutable.sumRegion(row1, col1, row2, col2));
    }

    private void testMatrix0() {
        rangeSumQuery2DImmutable = new RangeSumQuery2DImmutable(
                new int[][] {
                        {3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}
                }
        );
    }

}