package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SlightlySortArrayTest {

    private SlightlySortArray slightlySortArray;

    @Before
    public void setUp() throws Exception {
        slightlySortArray = new SlightlySortArray();
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        final int[] inputArray = new int[]{0, 4, 5, 3, 2, 1,};
        verify(inputArray, 2, 0, 3, 2, 1, 4, 5);
    }

    @Test
    public void totallySortIfKisLarge() throws Exception {
        final int[] inputArray = new int[]{7, 5, 9, 4, 8, 6, 2, 1, 3};
        verify(inputArray, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void neverSortIfKisZero() throws Exception {
        final int[] inputArray = new int[]{0, 4, 5, 3, 2, 1,};
        verify(inputArray, 0, 0, 4, 5, 3, 2, 1);
    }

    private void verify(final int[] inputArray, final int k, final int... expectedArray) {
        slightlySortArray.sort(inputArray, k);
        assertEquals(inputArray.length, expectedArray.length);
        for (int i = 0; i < expectedArray.length; i++) {
            System.out.format("%d, ", inputArray[i]);
            assertEquals(expectedArray[i], inputArray[i]);
        }
    }
}