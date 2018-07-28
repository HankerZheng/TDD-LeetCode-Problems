package com.hankerzheng.tddleet;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZigZagIterator implements Iterator<Integer> {

    private LinkedList<List<Integer>> dataSource;
    private LinkedList<Integer> cursors;

    public ZigZagIterator(final List<List<Integer>> lists) {
        dataSource = new LinkedList<>();
        cursors = new LinkedList<>();
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null && lists.get(i).size() != 0) {
                dataSource.addLast(lists.get(i));
                cursors.add(0);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !dataSource.isEmpty();
    }

    @Override
    public Integer next() {
        final List<Integer> thisList = dataSource.removeFirst();
        final Integer thisIdx = cursors.removeFirst();
        Integer res = thisList.get(thisIdx);
        if (thisIdx + 1 < thisList.size()) {
            dataSource.addLast(thisList);
            cursors.addLast(thisIdx + 1);
        }
        return res;
    }
}
