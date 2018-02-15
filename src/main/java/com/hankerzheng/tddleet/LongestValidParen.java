package com.hankerzheng.tddleet;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 32. Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 *
 */

public class LongestValidParen {
    public int longestValidParentheses(String s) {
        final LinkedList<Integer> indexStack = new LinkedList<>();
        final HashMap<Integer, Integer> lastLength = new HashMap<>();
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                indexStack.addLast(i);
            } else if (s.charAt(i) == ')') {
                if (!indexStack.isEmpty()) {
                    int startIdx = indexStack.removeLast();
                    int thisLength = i - startIdx + 1 + lastLength.getOrDefault(startIdx - 1, 0);
                    maxLength = Math.max(maxLength, thisLength);
                    lastLength.put(i, thisLength);
                }
            }
        }
        return maxLength;
    }
}
