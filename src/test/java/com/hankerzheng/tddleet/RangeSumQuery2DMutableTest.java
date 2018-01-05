package com.hankerzheng.tddleet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RangeSumQuery2DMutableTest {


    private RangeSumQuery2DMutable rangeSumQuery2DMutable;


    @Test
    public void shouldPassGivenExample() throws Exception {
        testMatrix0();
        int result = rangeSumQuery2DMutable.sumRegion(2, 1, 4, 3);
        assertEquals(8, result);
        rangeSumQuery2DMutable.update(3, 2, 2);
        result = rangeSumQuery2DMutable.sumRegion(2, 1, 4, 3);
        assertEquals(10, result);
    }



    private void testMatrix0() {
        rangeSumQuery2DMutable = new RangeSumQuery2DMutable(
                new int[][] {
                        {3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}
                }
        );
    }

}