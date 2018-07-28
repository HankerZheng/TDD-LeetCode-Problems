package com.hankerzheng.tddleet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 499. The Maze III
 *
 * There is a ball in a maze with empty spaces and walls.
 * The ball can go through empty spaces by rolling up (u), down (d), left (l) or right (r),
 * but it won't stop rolling until hitting a wall.
 *
 * When the ball stops, it could choose the next direction.
 * There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.
 *
 * Given the ball position, the hole position and the maze,
 * find out how the ball could drop into the hole by moving the shortest distance.
 *
 * The distance is defined by the number of empty spaces traveled
 * by the ball from the start position (excluded) to the hole (included).
 *
 * Output the moving directions by using 'u', 'd', 'l' and 'r'.
 * Since there could be several different shortest ways,
 * you should output the lexicographically smallest way.
 * If the ball cannot reach the hole, output "impossible".
 *
 * The maze is represented by a binary 2D array.
 * 1 means the wall and 0 means the empty space.
 * You may assume that the borders of the maze are all walls.
 * The ball and the hole coordinates are represented by row and column indexes.
 *
 */
public class TiltMaze {

    // up: 0, down: 1, left: 2, right: 3

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        final int width = maze[0].length;
        final int target = hole[0] * width + hole[1];
        int curPos = ball[0] * width + ball[1];
        final LinkedList<Integer> queue = new LinkedList<>();
        final Map<Integer, Integer> visited = new HashMap<>();
        visited.put(curPos, null);
        queue.add(curPos);
        while (!queue.isEmpty()) {
            curPos = queue.removeFirst();
            if (curPos == target) {
                break;
            }
            checkAroundAndUpdate(curPos, target, maze, queue, visited);
        }
        if (curPos != target) {
            return "impossible!";
        }
        return constructStrategy(target, width, visited);
    }

    private String constructStrategy(final int target, final int width, final Map<Integer, Integer> visited) {
        final LinkedList<Character> res = new LinkedList<>();
        Integer curPos = target;
        while (curPos != null) {
            Integer beforePos = visited.get(curPos);
            if (beforePos != null) {
                res.addFirst(getOperation(beforePos, curPos, width));
            }
            curPos = beforePos;
        }
        return res.stream().map(e -> e.toString()).reduce((a, b) -> a + b).get();
    }

    private Character getOperation(final Integer beforePos, final Integer curPos, final int width) {
        if (beforePos / width == curPos / width) {
            return curPos > beforePos ? 'r' : 'l';
        } else {
            return curPos > beforePos ? 'd' : 'u';
        }
    }

    private void checkAroundAndUpdate(final int curPos, final int target, final int[][] maze, final LinkedList<Integer> queue, final Map<Integer, Integer> visited) {
        for (int i = 0; i < 4; i++) {
            int newPos = advanceToNewPos(curPos, i, target, maze);
            if (!visited.containsKey(newPos)) {
                visited.put(newPos, curPos);
                queue.addLast(newPos);
            }
        }
    }

    private int advanceToNewPos(final int curPos, final int direction, final int target, final int[][] maze) {
        int width = maze[0].length;
        int curRow = curPos / width, curCol = curPos % width;
        int delta = (direction & 1) == 1 ? 1 : -1;
        while(isPosInRange(curRow, curCol, maze) && !(maze[curRow][curCol] == 1 || curRow * width + curCol == target)) {
            curCol += (direction & 2) == 2 ? delta : 0;
            curRow += (direction & 2) == 0 ? delta : 0;
        }
        if (curRow * width + curCol == target) {
            return target;
        }
        curCol -= (direction & 2) == 2 ? delta : 0;
        curRow -= (direction & 2) == 0 ? delta : 0;
        return curRow * width + curCol;
    }

    private boolean isPosInRange(final int curRow, final int curCol, final int[][] maze) {
        return 0 <= curRow && curRow< maze.length
                && 0 <= curCol && curCol < maze[0].length;
    }

}
