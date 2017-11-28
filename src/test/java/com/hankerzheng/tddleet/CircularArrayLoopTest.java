package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircularArrayLoopTest {

    private CircularArrayLoop circularArrayLoop;

    @Before
    public void setUp() throws Exception {
        circularArrayLoop = new CircularArrayLoop();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfNull() throws Exception {
        circularArrayLoop.test(null);
    }

    @Test
    public void shouldReturnTrueForExampleGive() throws Exception {
        verify(new int[] {2, -1, 1, 2, 2}, true);
    }

    private void verify(int[] nums, boolean expected) {
        final boolean actual = circularArrayLoop.test(nums);
        assertEquals(expected, actual);
    }

}