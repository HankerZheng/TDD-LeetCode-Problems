package com.hankerzheng.tddleet;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ZigZagIteratorTest {


    private ZigZagIteratorWithCustomizedList solutionWithCustomizedList;
    private ZigZagIterator solution;


    @Test
    public void shouldReturnEmptyIfEmptyInput() throws Exception {
        verifyExpected(Lists.newArrayList());
    }

    @Test
    public void sameOutputAsInputIfOnlyOneList() throws Exception {
        verifyExpected(
                Lists.newArrayList(
                        Lists.newArrayList(1, 2, 3, 4, 5),
                        Lists.newArrayList()),
                1, 2, 3, 4, 5);
    }

    @Test
    public void zigZagOutputIfTwoLists() throws Exception {
        verifyExpected(
                Lists.newArrayList(
                        Lists.newArrayList(1, 2, 3, 4, 5),
                        Lists.newArrayList(6, 7)),
                1, 6, 2, 7, 3, 4, 5);
    }


    @Test
    public void zigZagOutputIfSeveralLists() throws Exception {
        verifyExpected(
                Lists.newArrayList(
                        Lists.newArrayList(1, 2, 3, 4, 5),
                        Lists.newArrayList(6, 7),
                        Lists.newArrayList(8, 9, 0, 1),
                        Lists.newArrayList(1),
                        Lists.newArrayList(9, 8, 7, 6, 5, 4)),
                1, 6, 8, 1, 9, 2, 7, 9, 8, 3, 0, 7, 4, 1, 6, 5, 5, 4);

        verifyExpected(
                Lists.newArrayList(
                        Lists.newArrayList(0),
                        Lists.newArrayList(1),
                        Lists.newArrayList(2),
                        Lists.newArrayList(3),
                        Lists.newArrayList(4)),
                0, 1, 2, 3, 4);
    }

    @Test
    public void shouldPassFailedTests() throws Exception {
        verifyExpected(
                Lists.newArrayList(
                        Lists.newArrayList(0),
                        Lists.newArrayList(0)),
                0, 0);
    }

    private void verifyExpected(final List<List<Integer>> lists, final Integer... expectedList) {
        solution = new ZigZagIterator(lists);
        solutionWithCustomizedList = new ZigZagIteratorWithCustomizedList(lists);

        List<Integer> res = new ArrayList<>();
        List<Integer> resWithCustomizedList = new ArrayList<>();

        while (solution.hasNext()) {
            res.add(solution.next());
        }
        while(solutionWithCustomizedList.hasNext()) {
            resWithCustomizedList.add(solutionWithCustomizedList.next());
        }
        assertEquals(res.size(), expectedList.length);
        assertEquals(resWithCustomizedList.size(), expectedList.length);

        for (int i = 0; i < expectedList.length; i++) {
            assertEquals(expectedList[i], res.get(i));
            assertEquals(expectedList[i], resWithCustomizedList.get(i));
        }
    }
}