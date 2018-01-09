package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueBinarySearchTreesIITest {

    private UniqueBinarySearchTreesII uniqueBinarySearchTreesII;

    @Before
    public void setUp() throws Exception {
        uniqueBinarySearchTreesII = new UniqueBinarySearchTreesII();
    }

    @Test
    public void shouldPassSmallInput() throws Exception {
        verify(0, 0);
        verify(1, 1);
        verify(2, 2);
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(5, 3);
    }

    private void verify(int expectedLength, int n) {
        assertEquals(expectedLength, uniqueBinarySearchTreesII.generateTrees(n).size());
    }

}