package com.hankerzheng.tddleet;

import java.util.LinkedList;

/**
 * 735. Asteroid Collision
 *
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction
 * (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will
 * explode. If both are the same size, both will explode. Two asteroids moving in the same direction will
 * never meet.
 *
 * Example 1:
 * Input:
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation:
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * Example 2:
 * Input:
 * asteroids = [8, -8]
 * Output: []
 * Explanation:
 * The 8 and -8 collide exploding each other.
 * Example 3:
 * Input:
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation:
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 * Example 4:
 * Input:
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation:
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 * Note:
 *
 * The length of asteroids will be at most 10000.
 * Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 *
 */
public class AsteroidCollision {

    /**
     * MY THOUGHTS:
     *
     * The collision for the left-moving asteroids only happens with the one to the left of him.
     * Therefore, we can simulate the situation where we sitting at the first right-moving asteroid
     * and wait for new coming asteroids to collide with us.
     *
     * Since we need frequently add and remove elements in the last of the collection, LinkedList would
     * be the best data structure for us to store the status of asteroids.
     *
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param asteroids
     * @return
     */

    public int[] asteroidCollision(int[] asteroids) {
        final LinkedList<Integer> status = new LinkedList<>();
        status.add(-1);
        for(int asteroid: asteroids) {
            if (canCollide(status.getLast(), asteroid)) {
                simulateCollision(status, asteroid);
            } else {
                status.add(asteroid);
            }
        }
        status.removeFirst();
        return constructArray(status);
    }

    private int[] constructArray(LinkedList<Integer> status) {
        final int[] results = new int[status.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = status.removeFirst();
        }
        return results;
    }

    private void simulateCollision(final LinkedList<Integer> status, final int asteroid) {
        while (canKeepColliding(status, asteroid)) {
            status.removeLast();
        }
        if (status.getLast() < 0) {
            status.add(asteroid);
        } else if (status.getLast() == -asteroid) {
            status.removeLast();
        }
    }

    private boolean canKeepColliding(LinkedList<Integer> status, int asteroid) {
        final int rightMost = status.getLast();
        return rightMost > 0 && rightMost < -asteroid;
    }

    private boolean canCollide(int rightMost, int asteroid) {
        return rightMost > 0 && asteroid < 0;
    }

}
