package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxChunksToMakeSortedTest {

    private MaxChunksToMakeSorted solution;

    @Before
    public void setUp() throws Exception {
        solution = new MaxChunksToMakeSorted();
    }

    @Test
    public void shouldReturnOneIfOnlyOneChunk() throws Exception {
        verify(1, 0);
    }

    @Test
    public void shouldReturnOneIfDescendingOrder() throws Exception {
        verify(1, 4, 3, 2, 1, 0);
    }

    @Test
    public void shouldReturnNIfAccendingOrder() throws Exception {
        verify(5, 0, 1, 2, 3, 4);
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(4, 1, 0, 2, 3, 4);
    }

    private void verify(final int expected, final int... nums) {
        assertEquals(expected, solution.maxChunksToSorted(nums));
    }

}