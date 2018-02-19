package com.hankerzheng.tddleet;

/**
 * 357. Count Numbers with Unique Digits
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 *
 * Example:
 * Given n = 2, return 91.
 * (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 *
 */
public class CountNumbersWithUniqueDigits {
    /**
     * f(n) = f(n - 1) + unique-n-figured-number
     *
     * unique-n-figured-number = 9 * PI{10 - i, 1 <= i < n}
     *
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int count =10;
        for (int i = 2; i <= n && i <= 10; i++) {
            int choice = 9;
            for (int j = 0; j < i - 1; j++) {
                choice *= (9 - j);
            }
            count += choice;
        }
        return count;
    }
}
