package com.hankerzheng.tddleet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 95. Unique Binary Search Trees II
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 *
 */

public class UniqueBinarySearchTreesII {

    private Map<Integer, List<TreeNode>> memResluts = new HashMap<>();
    private int maxN;

    public List<TreeNode> generateTrees(int n) {
        this.maxN = n + 1;
        return constructTree(1, n + 1);
    }

    private List<TreeNode> constructTree(int startNum, int endNum) {
        final List<TreeNode> results = new ArrayList<>();
        if (startNum == endNum) {
            return results;
        } else if (startNum == endNum - 1) {
            results.add(new TreeNode(startNum));
            return results;
        }
        int thisHashKey = startNum * maxN + endNum;
        if (memResluts.containsKey(thisHashKey)) {
            return memResluts.get(thisHashKey);
        }

        for (int i = startNum; i < endNum; i++) {
            final int thisRootVal = i;
            final List<TreeNode> lefts = constructTree(startNum, thisRootVal);
            final List<TreeNode> rights = constructTree(thisRootVal + 1, endNum);
            if (lefts.size() == 0) {
                rights.forEach(right -> generateResult(results, thisRootVal, null, right));
            } else if (rights.size() == 0) {
                lefts.forEach(left -> generateResult(results, thisRootVal, left, null));
            } else {
                lefts.forEach(left -> rights.forEach(right -> generateResult(results, thisRootVal, left, right)));
            }
        }
        memResluts.put(thisHashKey, results);
        return results;
    }

    private void generateResult(List<TreeNode> results, int thisRootVal, TreeNode left, TreeNode right) {
        TreeNode rootNode = new TreeNode(thisRootVal);
        rootNode.left = left;
        rootNode.right = right;
        results.add(rootNode);
    }

    static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
