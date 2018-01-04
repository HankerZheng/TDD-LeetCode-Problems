package com.hankerzheng.tddleet;

public class TwoValueMinPQItem implements Comparable<TwoValueMinPQItem> {
    private int left;
    private int right;

    TwoValueMinPQItem(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    @Override
    public int compareTo(TwoValueMinPQItem o) {
        return this.getLeft() - o.getLeft();
    }
}
