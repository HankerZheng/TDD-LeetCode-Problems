package com.hankerzheng.tddleet;

/**
 * 277. Find the Celebrity
 *
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
 * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 *
 * Now you want to find out who the celebrity is or verify that there is not one.
 * The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of
 * whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions
 * as possible (in the asymptotic sense).
 *
 * You are given a helper function bool knows(a, b) which tells you whether A knows B.
 * Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 *
 * Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there
 * is a celebrity in the party. If there is no celebrity, return -1.
 */


public class FindCelebrity {

    /**
     * MY THOUGHTS:
     *
     * The relationship between those people is a directed graph. We need to find the point which is the sink of
     * all other points, and is source of no relations.
     *
     * First, we find the candidate based on the direction of the relations. Consider all the people in the party as
     * an array, we first set people 0 as the candidate of celebrity.
     *
     *      If candidate knows X, then candidate must not be the celebrity, but X has the potential to
     *      be the celebrity, set X as candidate
     *
     *      If candidate doesn't know X, then X must not be the celebrity.
     *
     * Based on this rule, we could reach at a candidate K, who doesn't know any one after him.
     *
     * Since we arrived at candidate K because there is a relation chain constructed by the people before k, which
     * means all the people before k cannot be the celebrity.
     *
     * Since all people after K are not known to K, then they cannot be the celebrity
     *
     * Therefore, only candidate K has the potential to be the celebrity. All we need to do is to check its status
     * in one loop.
     *
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     *
     * @param n
     * @return
     */

    public int findCelebrity(int n) {

        int candidate = 0;
        for (int nextPerson = 1; nextPerson < n; nextPerson ++) {
            if (knows(candidate, nextPerson)) {
                candidate = nextPerson;
            }
        }

        for (int checkPerson = 0; checkPerson < n; checkPerson ++) {
            if (candidate == checkPerson || isPotentialCelebrity(candidate, checkPerson)) {
                continue;
            }
            return -1;
        }

        return candidate;
    }


    private boolean isPotentialCelebrity(int candidate, int checkPerson) {
        return !knows(candidate, checkPerson) && knows(checkPerson, candidate);
    }

    private boolean knows(int candidate, int checkPerson) {
        return false;
    }
}
