package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DailyTemperturesTest {

    private DailyTempertures solution;

    @Before
    public void setUp() throws Exception {
        solution = new DailyTempertures();
    }

    @Test
    public void shoudlPassGivenExample() throws Exception {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        verify(temperatures, 1, 1, 4, 2, 1, 1, 0, 0);
    }

    private void verify(final int[] temperatures, final int ... expected) {
        int[] actualRes = solution.dailyTemperatures(temperatures);
        assertArrayEquals(expected, actualRes);
    }

}