package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KthSmallestNumberInMultiTableTest {
    private KthSmallestNumberInMultiTable solution;

    @Before
    public void setUp() throws Exception {
        solution = new KthSmallestNumberInMultiTable();
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(3, 3, 3, 5);
        verify(2, 3, 3, 2);
        verify(9, 3, 3, 9);
    }

    @Test
    public void shouldPassFailedExample() throws Exception {
        verify(6, 2, 3, 6);
    }

    private void verify(final int expected, final int m, final int n, final int k) {
        assertEquals(expected, solution.findKthNumber(m, n, k));
    }

}