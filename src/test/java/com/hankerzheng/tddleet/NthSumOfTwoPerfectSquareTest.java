package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NthSumOfTwoPerfectSquareTest {


    private NthSumOfTwoPerfectSquare nthSumOfTwoPerfectSquare;

    @Before
    public void setUp() throws Exception {
        nthSumOfTwoPerfectSquare = new NthSumOfTwoPerfectSquare();
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(2, 1);
        verify(5, 2);
        verify(8, 3);
        verify(10, 4);
        verify(13, 5);
        verify(17, 6);
    }

    @Test
    public void shouldNotHaveDuplicate25() throws Exception {
        verify(15, 40);
    }

    @Test
    public void printOutResult() throws Exception {
        for (int i = 1; i < 50; i++) {
            System.out.format("%d \t %d\n",i, nthSumOfTwoPerfectSquare.nthSumOfPerfectSquare(i));
        };
    }

    private void verify(int expected, int n) {
        assertEquals(expected, nthSumOfTwoPerfectSquare.nthSumOfPerfectSquare(n));
    }

}