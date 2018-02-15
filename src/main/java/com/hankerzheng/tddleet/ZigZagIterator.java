package com.hankerzheng.tddleet;

import java.util.ArrayList;
import java.util.List;

/*
 * 281. Zigzag Iterator follow up
 *
 * Given a list of list, create a zigZagIterator
 * Example, if given [1,2,3,4], [5,6], [7,8,9,0,0,0]
 * The zigZagIterator would return [1,5,7,2,6,8,3,9,4,0,0,0] sequentially
 */
public class ZigZagIterator {

    private CyclicLinkedListNode<List<Integer>> cursor;

    public ZigZagIterator() {
    }

    public void init(final List<List<Integer>> inputLists) {
        final CyclicLinkedListNode<List<Integer>> dummyNode = new CyclicLinkedListNode<>(new ArrayList<>());
        CyclicLinkedListNode<List<Integer>> lastNode = dummyNode;
        for (final List<Integer> list: inputLists) {
            if (!list.isEmpty()) {
                lastNode.addAfter(new CyclicLinkedListNode<>(list));
                lastNode = lastNode.getNext();
            }
        }
        lastNode.removeAfter();
        cursor = lastNode;
    }

    public int next() {
        final int retVal = popOneValueFromNode(cursor.getNext());
        if (isNodeExhausted(cursor.getNext())) {
            cursor.removeAfter();
        } else {
            cursor = cursor.getNext();
        }
        return retVal;
    }

    private boolean isNodeExhausted(final CyclicLinkedListNode<List<Integer>> item) {
        return item.getIndex() >= item.getItem().size();
    }

    private int popOneValueFromNode(final CyclicLinkedListNode<List<Integer>> item) {
        final int retVal = item.getItem().get(item.getIndex());
        item.updateIndex();
        return retVal;
    }

    public boolean hasNext() {
        return cursor.getNext() != null;
    }
}


class CyclicLinkedListNode<T> {

    private T item;
    private CyclicLinkedListNode<T> next;
    private int index;

    public CyclicLinkedListNode(final T item) {
        index = 0;
        this.item = item;
        this.next = this;
    }

    public void addAfter(CyclicLinkedListNode<T> node) {
        CyclicLinkedListNode<T> tmp = this.next;
        this.next = node;
        node.next  = tmp;
    }

    public void removeAfter() {
        if (this.next == this) {
            this.next = null;
            return;
        }
        this.next = this.next.next;
    }

    public CyclicLinkedListNode<T> getNext() {
        return next;
    }

    public T getItem() {
        return item;
    }

    public int getIndex() {
        return index;
    }

    public void updateIndex() {
        index += 1;
    }
}

