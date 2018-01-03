package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdditiveNumberTest {

    private AdditiveNumber additiveNumber;

    @Before
    public void setUp() throws Exception {
        additiveNumber = new AdditiveNumber();
    }

    @Test
    public void shouldReturnFalseIfInvalidInput() throws Exception {
        verify(false, null);
        verify(false, "");
        verify(false, "");

    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(true, "11235813");
        verify(true, "199100199");
    }

    @Test
    public void shouldPassMyFailedCases() throws Exception {
        verify(true, "123");
        verify(false, "1023");
        verify(true, "000");

    }

    private void verify(boolean expected, final String number) {
        assertEquals(expected, additiveNumber.isAdditiveNumber(number));
    }

}