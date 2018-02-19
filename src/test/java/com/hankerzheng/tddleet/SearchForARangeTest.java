package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchForARangeTest {

    private SearchForARange solution;

    @Before
    public void setUp() throws Exception {
        solution = new SearchForARange();
    }

    @Test
    public void shouldPassIfOnlyOneValueInArray() throws Exception {
        verify(0, 3, 1, 1, 1, 1, 1);
    }

    @Test
    public void shouldPassIfSearchForUniqueNumber() throws Exception {
        verify(0, 0, 0, 0, 1, 2, 3);
        verify(1, 1, 1, 0, 1, 2, 3);
        verify(2, 2, 2, 0, 1, 2, 3);
        verify(3, 3, 3, 0, 1, 2, 3);
    }

    @Test
    public void shouldReturnMinusOneIfNotFound() throws Exception {
        verify(-1, -1, -1, 0, 1, 3, 4);
        verify(-1, -1, 2, 0, 1, 3, 4);
        verify(-1, -1, 8, 0, 1, 3, 4);
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(3, 4, 6, 1, 2, 3, 6, 6, 7);
    }

    private void verify(final int start, final int end, final int target, final int ... nums) {
        final int[] acutal = solution.searchRange(nums, target);
        assertEquals(start, acutal[0]);
        assertEquals(end, acutal[1]);
    }

}