package com.hankerzheng.tddleet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StockWithTransactionFeeTest {

    private StockWithTransactionFee stockWithTransactionFee;

    @Before
    public void setUp() throws Exception {
        stockWithTransactionFee = new StockWithTransactionFee();
    }

    @Test
    public void shouldReturn0IfNoPrices() throws Exception {
        verify(0, 0);
    }

    @Test
    public void shouldReturn0IfOnlyOneDay() throws Exception {
        verify(0, 0, 1);
        verify(0, 10,1);
        verify(0, 1, 1);
    }

    @Test
    public void shouldPassGivenExample() throws Exception {
        verify(8, 2, 1, 3, 2, 8, 4, 9);
    }

    private void verify(final int expected, final int fee, final int ... prices) {
        assertEquals(expected, stockWithTransactionFee.maxProfit(prices, fee));
    }
}