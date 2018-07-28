package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumAverageSubarrayIITest {

    private MaximumAverageSubarrayII solution;

    @Before
    public void setUp() throws Exception {
        solution = new MaximumAverageSubarrayII();
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(12.75, 4, 1, 12, -5, -6, 50, 3);
    }

    @Test
    public void shouldPassFailedExample() throws Exception {
        verify(5, 1, 5);
        verify(7, 7, 7, 4, 5, 8, 8, 3, 9, 8, 7, 6);
    }

    private void verify(final double expected, final int k, final int... nums) {
        assertEquals(expected, solution.findMaxAverage(nums, k), 1e-6);
    }

}