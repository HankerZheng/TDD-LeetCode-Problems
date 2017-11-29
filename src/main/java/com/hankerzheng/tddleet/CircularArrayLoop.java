package com.hankerzheng.tddleet;

/**
 *
 * LeetCode 457. Circular Array Loop
 *
 *
 * Note: this solution won't pass LeetCode 457 official test case, since I make forward and
 *       backword loop valid.
 *
 *
 * You are given an array of positive and negative integers.
 * If a number n at an index is positive, then move forward n steps.
 * Conversely, if it's negative (-n), move backward n steps.
 * Assume the first element of the array is forward next to the last element,
 * and the last element is backward next to the first element.
 * Determine if there is a loop in this array.
 *
 * A loop starts and ends at a particular index with more than 1 element along the loop.
 * The loop must be "forward" or "backward'.
 *
 *
 * Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.
 *
 * Example 2: Given the array [-1, 2], there is no loop.
 *
 * Note: The given array is guaranteed to contain no element "0".
 *
 * Can you do it in O(n) time complexity and O(1) space complexity?
 */


import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.abs;
import static java.lang.Math.floorMod;

/**
 * THOUGHTS:
 *
 * Every point can point to either the point that has been visited or not.
 * If it points to the point that has been visited and that point is not itself,
 * then there is a loop.
 * If it points to the point that is not visited, then we mark current point as
 * visited, and move to the new point.
 *
 * So on so forth.
 * When we arrive at the last point, it must point to a visited point. Therefore,
 * there must be at least one loop in this array.
 *
 * Then all we need to do is to check whether there exists a loop with more than
 * one elements.
 *
 *
 * Then we can do unionFind to check how many isolated union are there in the array
 * And if there exists at least one union without any element points to itself, we
 * can assert that this array has at least one circular array loop
 *
*/

public class CircularArrayLoop {

   public boolean test(int[] nums) {
      if (nums == null || nums.length == 0) {
         throw new IllegalArgumentException("Empty Input!");
      }

      if (nums.length == 1) {
         return false;
      }

      final UnionFind unionFind = new UnionFind(nums.length);
      for (int curPos = 0; curPos < nums.length; curPos++) {
          final int nextPos = findNext(nums, curPos);
          unionFind.union(curPos + 1, nextPos + 1);
          if (curPos == nextPos) {
              unionFind.setInvalid(curPos + 1);
          }
      }

      return unionFind.checkValidArray();
   }

   private int findNext(int[] nums, final int curPos) {
       return floorMod(curPos + nums[curPos], nums.length);
   }


    /**
     * This is the customized Union Find implementation!
     */
   class UnionFind {
       private int[] nums;

       public UnionFind(final int size) {
           this.nums = new int[size + 1];
           for (int i = 0; i < nums.length; i++) {
               nums[i] = i;
           }
       }

       public void union(final int pos0, final int pos1) {
           if (pos0 == pos1) { return; }
           int parent0 = find(pos0);
           int parent1 = find(pos1);
           if ((parent0 ^ parent1) < 0) {
               nums[parent1] = - abs(nums[parent0]);
           } else {
               nums[parent1] = nums[parent0];
           }
       }

       public int find(final int pos) {
           final Set<Integer> visited = new HashSet<>();
           int curPos = pos;
           while(curPos != nextPos(curPos)) {
               visited.add(curPos);
               curPos = nextPos(curPos);
           }
           final int parentPos = curPos;
           visited.forEach(e -> nums[e] = parentPos);
           return parentPos;
       }

       public void setInvalid(final int pos) {
           final int parent = find(pos);
           nums[parent] = -abs(parent);
       }

       private int nextPos(final int curPos) {
           return abs(nums[curPos]);
       }

       public boolean checkValidArray() {
           for (int i = 0; i < nums.length; i++) {
               if (nums[find(i)] > 0) {
                   return true;
               }
           }
           return false;
       }
   }

}
