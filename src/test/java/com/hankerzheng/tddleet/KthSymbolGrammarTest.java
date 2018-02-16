package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KthSymbolGrammarTest {

    private KthSymbolGrammar kthSymbolGrammar;

    @Before
    public void setUp() throws Exception {
        kthSymbolGrammar = new KthSymbolGrammar();
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(0, 1, 1);
        verify(0, 2, 1);
        verify(1, 2, 2);
        verify(1, 4, 5);
    }

    private void verify(final int expected, final int n, final int k) {
        assertEquals(expected, kthSymbolGrammar.kthGrammar(n, k));
    }

}