package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmptySlotsTest {

    private EmptySlots emptySlots;

    @Before
    public void setUp() throws Exception {
        emptySlots = new EmptySlots();
    }

    @Test
    public void emptyListShouldReturnMinusOne() throws Exception {
        verify(-1, 3);
    }

    @Test
    public void oneElementListShouldReturnMinusOne() throws Exception {
        verify(-1, 0, 1);
    }

    @Test
    public void shouldAlwaysHaveDayIfKisZero() throws Exception {
        verify(3, 0, 4, 2, 5, 3, 1);
        verify(2, 0, 4, 3, 5, 2, 1);
    }

    @Test
    public void shouldReturnMinusOneIfNoDayFound() throws Exception {
        verify(-1, 1, 1, 2, 3);
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(2, 1, 1, 3, 2);
    }

    private void verify(final int expectedDay, final int k, final int... flowers) {
        assertEquals(expectedDay, emptySlots.kEmptySlotsOn(flowers, k));
        assertEquals(expectedDay, emptySlots.kEmptySlots(flowers, k));
    }

}