package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AsteroidCollisionTest {

    private AsteroidCollision asteroidCollision;

    @Before
    public void setUp() throws Exception {
        asteroidCollision = new AsteroidCollision();
    }

    @Test
    public void handleIfNotAsteroids() throws Exception {
        verify(new int[]{});
    }

    @Test
    public void handleIf2Asteroids() throws Exception {
        verify(new int[]{-1, 1}, -1, 1);
        verify(new int[]{1, -1});
        verify(new int[]{2, -1}, 2);
        verify(new int[]{1, -2}, -2);
    }

    @Test
    public void shouldHandleGivenTest() throws Exception {
        verify(new int[]{5, 10, -5}, 5, 10);
        verify(new int[]{8, -8});
        verify(new int[]{10, 2, -5}, 10);
        verify(new int[]{-2, -1, 1, 2}, -2, -1, 1, 2);
    }

    private void verify(final int[] asteroids, final int ... expectedRes) {
        final int[] actualRes = asteroidCollision.asteroidCollision(asteroids);
        assertEquals(expectedRes.length, actualRes.length);
        for (int i = 0; i < expectedRes.length; i++) {
            assertEquals(expectedRes[i], actualRes[i]);
        }
    }
}