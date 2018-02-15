package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestValidParenTest {

    private LongestValidParen longestValidParen;

    @Before
    public void setUp() throws Exception {
        longestValidParen = new LongestValidParen();
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(")()())", 4);
        verify(")(()))", 4);
    }

    @Test
    public void shouldPassFailedCases() throws Exception {
        verify("()(())", 6);
        verify("()()()()()()", 12);
    }
    private void verify(final String s, final int expectedAns) {
        assertEquals(expectedAns, longestValidParen.longestValidParentheses(s));
    }

}