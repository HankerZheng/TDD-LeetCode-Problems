package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstMissingPositiveTest {

    private FirstMissingPositive firstMissingPositive;

    @Before
    public void setUp() throws Exception {
        firstMissingPositive = new FirstMissingPositive();
    }

    @Test
    public void shouldPassSmallExample() throws Exception {
        verify(1, 2);
        verify(2, 1);
        verify(1, 2, -1, 0);
        verify(1, 0, -1, 2);
    }

    @Test
    public void shouldPassIfDuplicatedNumbers() throws Exception {
        verify(1, 2, 2, 2, 2, 2, 2, 2);
        verify(1, 0, 0, 0, 0, 0, 0, 0);
        verify(1, -1, -1, -1, -1, -1);
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(3, 1, 2, 0);
        verify(2, 3, 4, -1, 1);
    }

    @Test
    public void shouldReturnMaxValidAndMinValid() throws Exception {
        verify(4, 1, 2, 3);
        verify(1, 4, 2, 3);
    }

    private void verify(final int expected, final int ... nums) {
        assertEquals(expected, firstMissingPositive.firstMissingPositive(nums));
    }

}