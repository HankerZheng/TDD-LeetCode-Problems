package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SuperUglyNumberTest {
    private SuperUglyNumber superUglyNumber;

    @Before
    public void setUp() throws Exception {
        superUglyNumber = new SuperUglyNumber();
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(32, 12, 2, 7, 13, 19);
    }

    @Test
    public void shouldPassIfOnlyOnePrimes() throws Exception {
        verify(1024, 10, 2);
    }

    private void verify(final int expected, int n, int ... primes) {
        assertEquals(expected, superUglyNumber.nthSuperUglyNumber(n, primes));
    }

}