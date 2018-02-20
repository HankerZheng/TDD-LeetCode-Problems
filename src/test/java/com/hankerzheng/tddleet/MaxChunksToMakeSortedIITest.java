package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxChunksToMakeSortedIITest {

    private MaxChunksToMakeSortedII solution;

    @Before
    public void setUp() throws Exception {
        solution = new MaxChunksToMakeSortedII();
    }

    @Test
    public void shouldReturnNIfAllNumberIsSame() throws Exception {
        verify(1, 11);
        verify(2, 14, 14);
        verify(4, 1, 1, 1, 1);
    }

    @Test
    public void shouldReturnNIfAccendingOrder() throws Exception {
        verify(4, 0, 1, 2, 3);
        verify(4, 0, 1, 1, 3);
        verify(4, 0, 0, 1, 3);
        verify(4, 0, 1, 3, 3);
        verify(4, 0, 1, 1, 1);
    }

    @Test
    public void shouldReturnOneIfDecendingOrder() throws Exception {
        verify(1, 4, 3, 2, 1);
        verify(1, 4, 4, 2, 1);
        verify(1, 4, 4, 4, 1);
        verify(1, 4, 3, 3, 1);
        verify(1, 4, 1, 1, 1);
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(4, 2, 1, 3, 4, 4);
    }

    @Test
    public void shouldPassFailedExample() throws Exception {
        verify(3, 1, 0, 1, 3, 2);
    }

    private void verify(final int expected, final int ... nums) {
        assertEquals(expected, solution.maxChunksToSorted(nums));
        assertEquals(expected, solution.maxChunksToSortedWithoutTree(nums));
    }

}