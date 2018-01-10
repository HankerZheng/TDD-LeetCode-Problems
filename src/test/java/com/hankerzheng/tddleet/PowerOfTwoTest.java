package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PowerOfTwoTest {

    private PowerOfTwo powerOfTwo;

    @Before
    public void setUp() throws Exception {
        powerOfTwo = new PowerOfTwo();
    }

    @Test
    public void falseGivenZero() throws Exception {
        verify(false, 0);
    }

    @Test
    public void falseGiveNegative() throws Exception {
        verfyMultipleNumbers(false, -1, -2, -8, 0x8000_0000);
    }

    @Test
    public void falseGivenNonPowerOfTwo() throws Exception {
        verfyMultipleNumbers(false, 3, 5, 7, 11, 13, 23, 63, 12, 0x1f00);
    }

    @Test
    public void trueGivenPowerOfTwo() throws Exception {
        verfyMultipleNumbers(true, 1, 2, 4, 8, 0x4000_0000);
    }

    private void verfyMultipleNumbers(final boolean expected, final int ... falseNumbers) {
        for (final int num: falseNumbers) {
            verify(expected, num);
        }
    }


    private void verify(final boolean expected, final int n) {
        assertEquals(expected, powerOfTwo.isPowerOfTwo(n));
    }

}