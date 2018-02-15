package com.hankerzheng.google.interview;

/*
 * This is an immutable class of a point in the 2D plane.
 * Utility methods could be added to this class
 *
 */
public class Position2D {

    private int x;
    private int y;

    static Position2D of(final int x, final int y) {
        return new Position2D(x, y);
    }

    private Position2D(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public boolean nextTo(final Position2D o) {
        int delX = x - o.getX();
        int delY = y - o.getY();
        return delX * delY == 0 && Math.abs(delX + delY) == 1;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Position2D that = (Position2D) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }


}
