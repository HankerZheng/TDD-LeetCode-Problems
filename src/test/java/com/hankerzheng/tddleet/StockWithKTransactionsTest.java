package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StockWithKTransactionsTest {

    private StockWithKTransactions stockWithKTransactions;

    @Before
    public void setUp() throws Exception {
        stockWithKTransactions = new StockWithKTransactions();
    }

    @Test
    public void shouldPassGivenTest() throws Exception {
        verify(9, 2, 2,9,4,6);
    }

    private void verify(final int expected, final int k, final int ... prices) {
        assertEquals(expected, stockWithKTransactions.maxProfit(k, prices));
    }

}