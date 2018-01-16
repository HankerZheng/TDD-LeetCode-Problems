package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RedundantConnectionIITest {
    private RedundantConnectionII redundantConnection;

    @Before
    public void setUp() throws Exception {
        redundantConnection = new RedundantConnectionII();
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(2, 3, 1, 2, 1, 3, 2, 3);
        verify(4, 1, 1, 2, 2, 3, 3, 4, 4, 1, 1, 5);
    }

    @Test
    public void shouldPassFailedTest() throws Exception {
        verify(2, 1, 2, 1, 3, 1, 4, 2, 1, 4);
    }

    private void verify(final int expectedLeft, final int expectedRight, final int... edges) {
        final int[][] inputEdges = consturctEdges(edges);
        final int[] actualRes = redundantConnection.findRedundantDirectedConnection(inputEdges);
        assertEquals(expectedLeft, actualRes[0]);
        assertEquals(expectedRight, actualRes[1]);
    }

    private int[][] consturctEdges(int... edges) {
        if (edges == null || edges.length == 0) {
            return new int[0][2];
        }
        final int[][] res = new int[edges.length / 2][2];
        int idx = 0;
        while (idx < edges.length) {
            res[idx / 2][0] = edges[idx];
            res[idx / 2][1] = edges[idx + 1];
            idx += 2;
        }
        return res;
    }
}