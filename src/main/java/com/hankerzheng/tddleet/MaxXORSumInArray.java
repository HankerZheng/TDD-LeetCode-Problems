package com.hankerzheng.tddleet;

import java.util.HashSet;
import java.util.Set;

/**
 * 421. Maximum XOR of Two Numbers in an Array
 *
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 *
 * Could you do this in O(n) runtime?
 *
 */
public class MaxXORSumInArray {
    /**
     * use the prefix to find the match.
     *
     * A much easy-understanding solution is to construct a trie tree.
     * Every time when we try to add a new number to the tree, we would return the
     * max XOR value of the new added number and all the existing number in O(lg n) time
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        int mask = 0;
        int ans = 0;
        for (int bit = 31; bit >= 0; bit--) {
            final Set<Integer> prefixSet = new HashSet<>();
            mask = mask | 1 << bit;
            for (int i = 0; i < nums.length; i++) {
                prefixSet.add(nums[i] & mask);
            }
            int tmpAns = ans | (1 << bit);
            for (int i = 0; i < nums.length; i++) {
                if (prefixSet.contains((nums[i] & mask) ^ tmpAns)){
                    ans = tmpAns;
                    break;
                }
            }
        }
        return ans;
    }
}
