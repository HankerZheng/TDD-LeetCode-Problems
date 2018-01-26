package com.hankerzheng.tddleet;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 716. Max Stack
 *
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 *
 *  push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
 * Example 1:
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * Note:
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 * */

public class MaxStack {

        /**
         * MY THOUGHTS:
         *
         * One stack to store data, one priorityQueue to store max values
         *
         * push: O(log n)
         * pop: O(log n)
         * top: O(1)
         * peekMax: O(1)
         * popMax: O(n)
         *
         *
         * Better Solution:
         *
         * Maintain a node {value, maxValue}.
         * Maintain a doubly linked list with element as Node.
         *
         * push: O(1)
         * pop: O(1)
         * top: O(1)
         * peekMax: O(1)
         * popMax: O(n)
         *
         *
         */
    private PriorityQueue<Integer> pq;
    private LinkedList<Integer> stack;

    public MaxStack() {
        pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(final Integer o1, final Integer o2) {
                return o2 - o1;
            }
        });
        stack = new LinkedList<>();
    }

    public void push(int x) {
        pq.offer(x);
        stack.addLast(x);
    }

    public int pop() {
        final int poppedItem = stack.removeLast();
        pq.remove(poppedItem);
        return poppedItem;
    }

    public int top() {
        return stack.getLast();
    }

    public int peekMax() {
        return pq.peek();
    }

    public int popMax() {
        int curMax = pq.poll();
        final LinkedList<Integer> tempStack = new LinkedList<>();
        while (stack.getLast() != curMax) {
            tempStack.addFirst(stack.removeLast());
        }
        stack.removeLast();
        stack.addAll(tempStack);
        return curMax;
    }
}
