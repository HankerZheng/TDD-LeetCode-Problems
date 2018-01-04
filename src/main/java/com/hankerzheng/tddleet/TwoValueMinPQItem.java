package com.hankerzheng.tddleet;

public class TwoValueMinPQItem implements Comparable<TwoValueMinPQItem> {
    private int value;
    private int index;

    TwoValueMinPQItem(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(TwoValueMinPQItem o) {
        return this.getValue() - o.getValue();
    }
}
