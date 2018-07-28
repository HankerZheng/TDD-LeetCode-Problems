package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimizeMaxDistanceToGasStationTest {

    private MinimizeMaxDistanceToGasStation minimizeMaxDistanceToGasStation;
    private double error;

    @Before
    public void setUp() throws Exception {
        minimizeMaxDistanceToGasStation = new MinimizeMaxDistanceToGasStation();
        error = 1e-6;
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(0.5, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    private void verify(final double expected, final int k, final int ... stations) {
        assertEquals(expected, minimizeMaxDistanceToGasStation.minmaxGasDist(stations, k), 1e-6);
    }
}