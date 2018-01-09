package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniqueBinarySearchTreesTest {

    private UniqueBinarySearchTrees uniqueBinarySearchTrees;

    @Before
    public void setUp() throws Exception {
        uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
    }

    @Test
    public void shouldPassEasyCases() throws Exception {
        verify(1, 0);
        verify(1, 1);
        verify(2, 2);
    }


    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(5, 3);
    }

    private void verify(int expected, int givenN) {
        assertEquals(expected, uniqueBinarySearchTrees.numTrees(givenN));
    }
}