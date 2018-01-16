package com.hankerzheng.tddleet;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnionFindTest {

    @Test
    public void testUnionFindWithSizeOne() throws Exception {
        final UnionFind unionFind = new UnionFind(1);
        assertEquals(1, unionFind.find(1) );
        assertEquals(1, unionFind.count(1));
    }

    @Test
    public void testUnionFindWithSizeTwo() throws Exception {
        final UnionFind unionFind = new UnionFind(2);
        assertEquals(1, unionFind.find(1));
        assertEquals(2, unionFind.find(2));
        unionFind.union(1, 2);
        assertTrue(unionFind.find(1) == unionFind.find(2));
        assertEquals(2, unionFind.count(1));
    }

    @Test
    public void testUnionFindWithSizeThree() throws Exception {
        final UnionFind unionFind = new UnionFind(3);
        assertEquals(1, unionFind.find(1));
        assertEquals(2, unionFind.find(2));
        assertEquals(3, unionFind.find(3));
        unionFind.union(1, 2);
        unionFind.union(1, 3);
        assertTrue(unionFind.find(1) == unionFind.find(2));
        assertTrue(unionFind.find(3) == unionFind.find(2));
        assertEquals(3, unionFind.count(1));
        assertEquals(3, unionFind.count(2));
        assertEquals(3, unionFind.count(3));
    }

    @Test
    public void testUnionFindOnFailedExample() throws Exception {
        final UnionFind unionFind = new UnionFind(6);
        unionFind.union(1, 2);
        unionFind.union(2, 3);
        unionFind.union(3, 4);
        unionFind.union(1, 4);
        unionFind.union(1, 5);
    }
}