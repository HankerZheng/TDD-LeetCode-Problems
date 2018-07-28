package com.hankerzheng.tddleet;

/**
 * 375. Guess Number Higher or Lower II
 *
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 *
 * However, when you guess a particular number x, and you guess wrong, you pay $x.
 * You win the game when you guess the number I picked.
 *
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 *
 */
public class GuessNumberHigerOrLowerII {

    public int getMoneyAmount(int n) {
        int[][] memRes = new int[n + 1][n + 1];
        return helper(n, 0, memRes);
    }

    private int helper(final int n, final int k, final int[][] memRes) {
        if (memRes[n][k] != 0) {
            return memRes[n][k];
        }
        if (n <= 1) {
            return 0;
        } else if (n == 2) {
            return k + 1;
        } else if (n == 3) {
            return k + 2;
        }

        int res = Integer.MAX_VALUE;
        // since we know if we don't pay money, we should search the mid
        // then if we pay money, we should search a little bit after the mid
        for (int i = n / 2; i <= n; i++) {
            res = Math.min(res,
                    Math.max(helper(i - 1, k, memRes), helper(n - i, k + i, memRes)) + k + i);
        }
        memRes[n][k] = res;
        return res;
    }
}
