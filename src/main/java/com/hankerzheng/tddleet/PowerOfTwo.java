package com.hankerzheng.tddleet;

/**
 * 231. Power of Two
 *
 * Given an integer, write a function to determine if it is a power of two.
 */

public class PowerOfTwo {

    /**
     * MY THOUGHTS:
     *
     * Enlightened by the algorithm of Binary Indexed Tree:
     *
     *     Binary Representation of  2^n when positive: 000...0100...0
     *     Binary Representation of -2^n when positive: 111...1100...0
     *
     * Thus we have, (2^n) & (-2^n) == 2^n
     *
     *
     * @param n
     * @return
     */

    public boolean isPowerOfTwo(int n) {
        final boolean zeroOrNegative = n <= 0;
        final boolean onlyOneSetBit = ((-n) & n) == n;
        return (!zeroOrNegative) && onlyOneSetBit;
    }

}
