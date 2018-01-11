package com.hankerzheng.tddleet;

import java.util.LinkedList;
import java.util.List;

/**
 * UnionFind implementation with number count.
 *
 */
public class UnionFind {

    private int[] status;

    public UnionFind(final int n) {
        status = new int[n + 1];
        for (int i = 0; i < status.length; i++) {
            status[i] = -1;
        }
    }


    public void union(final int a, final int b) {
        final int parentA = find(a);
        final int parentB = find(b);
        status[parentA] += status[parentB];
        status[parentB] = parentA;
    }

    public int find(final int a) {
        if (a < 0) {
            return a;
        }
        final List<Integer> setA = new LinkedList<>();
        int thisNode = a;
        while (status[thisNode] > 0) {
            setA.add(thisNode);
            thisNode = status[thisNode];
        }
        for(int node: setA) {
            status[node] = thisNode;
        }
        return thisNode;
    }

    public int count(final int a) {
        return -status[find(a)];
    }
}
