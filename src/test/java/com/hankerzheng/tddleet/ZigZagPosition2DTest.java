package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZigZagPosition2DTest {

    ZigZagPosition2D point;

    @Before
    public void setUp() throws Exception {
        point = new ZigZagPosition2D(0, 0);
    }

    @Test
    public void CannotMoveIfSpaceIsEmpty() throws Exception {
        assertFalse(point.updatePosition(0, 0));
        assertFalse(point.updatePosition(0, 100));
        assertFalse(point.updatePosition(100, 0));
    }

    @Test
    public void MoveCorrectIn2By2Grid() throws Exception {
        verify(0, 0);
        point.updatePosition(2, 2);
        verify(1, 0);
        point.updatePosition(2, 2);
        verify(1, 1);
        point.updatePosition(2, 2);
        verify(0, 1);
        assertFalse(point.updatePosition(2, 2));
    }

    private void verify(final int expectedX, final int expectedY) {
        assertEquals(expectedX, point.getX());
        assertEquals(expectedY, point.getY());
    }

}