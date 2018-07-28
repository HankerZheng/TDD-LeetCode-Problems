package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuessNumberHigerOrLowerIITest {

    private GuessNumberHigerOrLowerII guessNumberHigerOrLowerII;

    @Before
    public void setUp() throws Exception {
        guessNumberHigerOrLowerII = new GuessNumberHigerOrLowerII();
    }

    @Test
    public void shouldPassSmallInput() throws Exception {
        verify(0,1);
        verify(1,2);
        verify(2,3);
        verify(4,4);
        verify(6,5);
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(16, 10);
    }

    private void verify(final int expected, final int n) {
        assertEquals(expected, guessNumberHigerOrLowerII.getMoneyAmount(n));
    }
}