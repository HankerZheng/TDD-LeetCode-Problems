package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwapAdjacentInLRStringTest {

    private SwapAdjacentInLRString swapAdjacentInLRString;

    @Before
    public void setUp() throws Exception {
        swapAdjacentInLRString = new SwapAdjacentInLRString();
    }

    @Test
    public void shouldPassIfGivenEmptyString() throws Exception {
        verify(true, "", "");
    }

    @Test
    public void shouldPassIfOnlyMoveLeft() throws Exception {
        verify(true, "XXXL", "LXXX");
        verify(true, "XXXL", "XLXX");
        verify(true, "XXXL", "XXLX");
        verify(true, "XXXL", "XXXL");
    }

    @Test
    public void shouldPassIfOnlyMoveRight() throws Exception {
        verify(true, "RXXX", "RXXX");
        verify(true, "RXXX", "XRXX");
        verify(true, "RXXX", "XXRX");
        verify(true, "RXXX", "XXXR");
    }

    @Test
    public void shouldPassGivenExamples() throws Exception {
        verify(true, "RXXLRXRXL", "XRLXXRRLX");
    }

    @Test
    public void shouldPassFailedExample() throws Exception {
        verify(false, "L", "X");
        verify(false, "X", "L");
    }

    private void verify(final boolean expected, final String start, final String end) {
        assertEquals(expected, swapAdjacentInLRString.canTransform(start, end));
    }
}