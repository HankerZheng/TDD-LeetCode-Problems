package com.hankerzheng.tddleet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        final LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        int baseIdx = 0;
        final LinkedList<TreeNode> queue = new LinkedList<>();
        final LinkedList<Integer> indexQueue = new LinkedList<>();
        queue.add(root);
        indexQueue.add(0);
        while(!queue.isEmpty()) {
            final TreeNode thisNode = queue.removeFirst();
            final int relativeIndex = indexQueue.removeFirst();
            final int rowIdx = relativeIndex + baseIdx;
            baseIdx = updateResultAndBaseIdx(result, baseIdx, thisNode, rowIdx);
            addNewNode(queue, indexQueue, thisNode, relativeIndex);
        }
        return result;
    }

    private void addNewNode(final LinkedList<TreeNode> queue, final LinkedList<Integer> indexQueue, final TreeNode thisNode, final int relativeIdx) {
        if (thisNode.left != null) {
            queue.addLast(thisNode.left);
            indexQueue.addLast(relativeIdx - 1);
        }
        if (thisNode.right != null) {
            queue.addLast(thisNode.right);
            indexQueue.addLast(relativeIdx + 1);
        }
    }

    private int updateResultAndBaseIdx(final LinkedList<List<Integer>> result, int baseIdx, final TreeNode thisNode, final int rowIdx) {
        if (rowIdx == -1) {
            final List<Integer> thisLevel = new ArrayList<>();
            thisLevel.add(thisNode.val);
            result.addFirst(thisLevel);
            baseIdx++;
        } else if (rowIdx >= result.size()) {
            final List<Integer> thisLevel = new ArrayList<>();
            thisLevel.add(thisNode.val);
            result.addLast(thisLevel);
        } else {
            result.get(rowIdx).add(thisNode.val);
        }
        return baseIdx;
    }


}
