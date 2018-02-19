package com.hankerzheng.tddleet;

import java.util.HashSet;
import java.util.Set;

public class MaxXORSumInArray {
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
