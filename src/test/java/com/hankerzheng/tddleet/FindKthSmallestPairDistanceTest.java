package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindKthSmallestPairDistanceTest {

    private FindKthSmallestPairDistance solution;

    @Before
    public void setUp() throws Exception {
        solution = new FindKthSmallestPairDistance();
    }

    @Test
    public void shouldPassIfKisTotalPairNumber() throws Exception {
        verify(2, 3,1, 2, 3);
    }

    @Test
    public void shouldPassExampleIfOnlyOneNumber() throws Exception {
        verify(0, 1, 1, 1);
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(0, 1, 1, 1, 3);
        verify(2, 2, 1, 1, 3);
        verify(2, 3, 1, 1, 3);
    }

    private void verify(final int expected, final int k, final int ... nums) {
        assertEquals(expected, solution.smallestDistancePair(nums, k));
    }
}