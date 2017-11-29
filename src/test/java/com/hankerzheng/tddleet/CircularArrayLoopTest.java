package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
    public void shouldReturnFalseIfOnlyOneElement() throws Exception {
        // All positive integers have the same effect if there is only one element in the array
        // So do all the negative integers
        for (int i = -1; i < 2; i++) {
            verify(false, i);
        }
    }

    @Test
    public void shouldReturnTrueIfNoPointPointsItself() throws Exception {
        verify(true, 1,1,1,1,1);
        verify(true, 2,2,2,2,2);
        verify(true, -1, 1,-1,1);
    }

    @Test
    public void shouldPassExampleCase() throws Exception {
        verify(true, 2, -1, 1, 2, 2);
        verify(false, -1, 2);
    }

    @Test
    public void shouldReturnFalseIfEveryElementPointsItself() throws Exception {
        verify(false, 0, 0, 0, 0, 0);
    }
    
    @Test
    public void shouldReturnTrueIfOnePointsItselfButCircleExists() throws Exception {
        verify(true, 0, 1, -1);
    }

    private void verify(boolean expected, int... nums) {
        final boolean actual = circularArrayLoop.test(nums);
        assertEquals(Arrays.toString(nums), expected, actual);
    }

}