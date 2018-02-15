package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BurstBalloonTest {

    private BurstBalloon burstBalloon;

    @Before
    public void setUp() throws Exception {
        burstBalloon = new BurstBalloon();
    }

    @Test
    public void shouldGetZeroIfNoBalloon() throws Exception {
        verify(0);
    }

    @Test
    public void shouldGetScoreIfOnlyOneBalloon() throws Exception {
        verify(3, 3);
    }
    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(167, 3, 1, 5, 8);
    }


    private void verify(final int expected, final int ... balloons) {
        assertEquals(expected, burstBalloon.maxCoins(balloons));
    }

}