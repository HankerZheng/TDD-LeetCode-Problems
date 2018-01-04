package com.hankerzheng.tddleet;

public class UglyNumberPQItem implements Comparable<UglyNumberPQItem> {
    int value;
    int index;

    UglyNumberPQItem(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(UglyNumberPQItem o) {
        return this.getValue() - o.getValue();
    }
}
