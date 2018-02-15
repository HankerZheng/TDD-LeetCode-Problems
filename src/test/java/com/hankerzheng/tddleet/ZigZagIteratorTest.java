package com.hankerzheng.tddleet;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ZigZagIteratorTest {


    private ZigZagIterator zigZagIterator;

    @Before
    public void setUp() throws Exception {
        zigZagIterator = new ZigZagIterator();
    }

    @Test
    public void shouldReturnEmptyIfEmptyInput() throws Exception {
        zigZagIterator.init(Lists.newArrayList());
        verifyExpected();
    }

    @Test
    public void sameOutputAsInputIfOnlyOneList() throws Exception {
        zigZagIterator.init(Lists.newArrayList(
                Lists.newArrayList(1, 2, 3, 4, 5),
                Lists.newArrayList()
        ));
        verifyExpected(1, 2, 3, 4, 5);
    }

    @Test
    public void zigZagOutputIfTwoLists() throws Exception {
        zigZagIterator.init(Lists.newArrayList(
                Lists.newArrayList(1, 2, 3, 4, 5),
                Lists.newArrayList(6, 7)
        ));
        verifyExpected(1, 6, 2, 7, 3, 4, 5);
    }


    @Test
    public void zigZagOutputIfSeveralLists() throws Exception {
        zigZagIterator.init(Lists.newArrayList(
                Lists.newArrayList(1, 2, 3, 4, 5),
                Lists.newArrayList(6, 7),
                Lists.newArrayList(8, 9, 0, 1),
                Lists.newArrayList(1),
                Lists.newArrayList(9, 8, 7, 6, 5, 4)
        ));
        verifyExpected(1, 6, 8, 1, 9, 2, 7, 9, 8, 3, 0, 7, 4, 1, 6, 5, 5, 4);

        zigZagIterator.init(Lists.newArrayList(
                Lists.newArrayList(0),
                Lists.newArrayList(1),
                Lists.newArrayList(2),
                Lists.newArrayList(3),
                Lists.newArrayList(4)
        ));
        verifyExpected(0, 1, 2, 3, 4);
    }

    @Test
    public void shouldPassFailedTests() throws Exception {
        zigZagIterator.init(Lists.newArrayList(
                Lists.newArrayList(0),
                Lists.newArrayList(0)
        ));
        verifyExpected(0, 0);
    }

    private void verifyExpected(final Integer... expectedList) {
        final List<Integer> resList = new ArrayList<>();
        while (zigZagIterator.hasNext()) {
            resList.add(zigZagIterator.next());
        }
        System.out.println(resList);
        assertEquals(resList.size(), expectedList.length);
        for (int i = 0; i < expectedList.length; i++) {
            assertEquals(expectedList[i], resList.get(i));
        }
    }
}