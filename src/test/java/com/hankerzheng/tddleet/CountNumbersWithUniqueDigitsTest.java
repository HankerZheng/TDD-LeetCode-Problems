package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountNumbersWithUniqueDigitsTest {

    private CountNumbersWithUniqueDigits solution;

    @Before
    public void setUp() throws Exception {
        solution = new CountNumbersWithUniqueDigits();
    }

    @Test
    public void passEasyExample() throws Exception {
        verify(10, 1);
        verify(91, 2);
        verify(739, 3);
        verify(8877691, 10);
        verify(8877691, 13);
    }

    private void verify(final int expected, final int n) {
        assertEquals(expected, solution.countNumbersWithUniqueDigits(n));
    }

}