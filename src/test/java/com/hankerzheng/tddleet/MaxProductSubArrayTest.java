package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProductSubArrayTest {

    private MaxProductSubArray maxProductSubArray;

    @Before
    public void setUp() throws Exception {
        maxProductSubArray = new MaxProductSubArray();
    }

    @Test
    public void shouldReturnZeroIfNoInput() throws Exception {
        verify(0);
    }

    @Test
    public void shouldReturnCorrectIfOnlyOne() throws Exception {
        verify(3, 3);
        verify(-3, -3);
    }

    @Test
    public void shouldPassWithZero() throws Exception {
        verify(3, 3, 0, 2);
        verify(6, 2, 3, 0, 5);
    }

    @Test
    public void shouldPassWitNegatives() throws Exception {
        verify(6, -2, -3);
        verify(6, -2, 1, -3);
        verify(6, -2, 1, -1, -1, -3);
    }

    @Test
    public void shouldPassWithMixNegativeAndZeros() throws Exception {
        verify(0, -2, 0, -3);
        verify(6, -2, 0, -3, 6);
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(6, 2, 3, -2, 4);
    }



    private void verify(final int expected, final int ... nums) {
        assertEquals(expected, maxProductSubArray.maxProduct(nums));
    }

}