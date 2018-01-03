package com.hankerzheng.tddleet;

import org.junit.Before;

import static org.junit.Assert.assertEquals;


public class FindCelebrityTest {

    private FindCelebrity findCelebrity;

    @Before
    public void setUp() throws Exception {
        findCelebrity = new FindCelebrity();
    }


    private void verify(final int expected, final int n) {
        assertEquals(expected, findCelebrity.findCelebrity(n));
    }
}