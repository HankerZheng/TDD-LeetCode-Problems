package com.hankerzheng.tddleet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 685. Redundant Connection II
 *
 * In this problem, a rooted tree is a directed graph such that,
 * there is exactly one node (the root) for which all other nodes are descendants of this node,
 * plus every node has exactly one parent, except for the root node which has no parents.
 *
 * The given input is a directed graph that started as a rooted tree with
 * N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added.
 * The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges.
 * Each element of edges is a pair [u, v] that represents a directed
 * edge connecting nodes u and v, where u is a parent of child v.
 *
 * Return an edge that can be removed so that the resulting graph is
 * a rooted tree of N nodes. If there are multiple answers,
 * return the answer that occurs last in the given 2D-array.
 *
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given directed graph will be like this:
 * 1
 * / \
 * v   v
 * 2-->3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * Output: [4,1]
 * Explanation: The given directed graph will be like this:
 * 5 <- 1 -> 2
 *      ^    |
 *      |    v
 *      4 <- 3
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */

public class RedundantConnectionII {

    /**
     * MY THGOUTHS:
     *
     * A Diected Graph can be seen as a tree if and only if:
     *      1. There is no cycle in the graph
     *      2. Every node in the tree can have only one source
     *
     * We do two round of searching.
     *
     * In the first round, we find the edges that point to the same point,
     * if any pair edges found, the result should be in these two.
     *
     * In the second round, we find the edge which make the graph cyclic,
     * if no pair edges found in first round, just return this edge found,
     * if one pair found in first round, we skip the union of the candidate edge
     *
     * Finally, we would have two candidates and a unionFind object where all other
     * edges except the candidates are united.
     *
     * If one of the candidate cause both problems, that would be the answer.
     * If all of them only cause one problem, return the last one.
     *
     *
     * @param edges
     * @return
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        final UnionFind unionFind = new UnionFind(edges.length + 1);
        final Map<Integer, Integer> sourceRecord = new HashMap<>();
        final List<int[]> candidates = new ArrayList<>();
        for (final int[] edge: edges) {
            int source = edge[0];
            int dest = edge[1];
            if (isMultipleSource(sourceRecord, source, dest)) {
                candidates.add(new int[]{sourceRecord.get(dest), dest});
                candidates.add(edge);
            }
            sourceRecord.put(dest, source);
        }
        for (final int[] edge: edges) {
            int source = edge[0];
            int dest = edge[1];
            if (candidates.size() == 0 && isCycleInGraph(unionFind, source, dest)) {
                return edge;
            }
            if (!isInCandidates(candidates, source, dest)) {
                unionFind.union(source, dest);
            }
        }
        if (unionFind.find(candidates.get(0)[0]) == unionFind.find(candidates.get(0)[1])) {
            return candidates.get(0);
        } else {
            return candidates.get(1);
        }

    }

    private boolean isInCandidates(final List<int[]> candidates, final int source, final int dest) {
        return candidates.size() == 2 &&
                (candidates.get(0)[0] == source && candidates.get(0)[1] == dest ||
                candidates.get(1)[0] == source && candidates.get(1)[1] == dest);
    }

    private boolean isMultipleSource(Map<Integer, Integer> sourceRecord, int source, int dest) {
        return sourceRecord.containsKey(dest) && sourceRecord.get(dest) != source;
    }

    private boolean isCycleInGraph(final UnionFind unionFind, final int source, final int dest) {
        return unionFind.find(source) == unionFind.find(dest);
    }

}
