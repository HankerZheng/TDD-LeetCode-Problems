package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxXORSumInArrayTest {

    private  MaxXORSumInArray solution;

    @Before
    public void setUp() throws Exception {
        solution = new MaxXORSumInArray();
    }

    @Test
    public void shoudlPassGivenExample() throws Exception {
        verify(28, 3, 10, 5, 25, 2, 8);
    }

    private void verify(final int expected, final int ... nums) {
        assertEquals(expected, solution.findMaximumXOR(nums));
    }
}