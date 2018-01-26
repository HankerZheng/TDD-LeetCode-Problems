package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PathSumIVTest {

    private PathSumIV pathSumIV;

    @Before
    public void setUp() throws Exception {
        pathSumIV = new PathSumIV();
    }

    @Test
    public void shouldPassGivenTestCase() throws Exception {
        verify(12, 113, 215, 221);
    }

    private void verify(final int expected, final int ... nodes) {
        assertEquals(expected, pathSumIV.pathSum(nodes));
    }
}