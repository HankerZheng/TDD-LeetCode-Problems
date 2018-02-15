package com.hankerzheng.tddleet;

public class ZigZagPosition2D {
    private int x;
    private int y;
    private boolean goRight;

    public ZigZagPosition2D(final int x, final int y) {
        this.x = x;
        this.y = y;
        goRight = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean updatePosition(final int maxX, final int maxY) {
        if (goRight && canGoRight(maxX, maxY)) {
            x += 1;
        } else if (!goRight && canGoLeft(maxX, maxY)) {
            x -= 1;
        } else if (canGoDown(maxX, maxY)) {
            goDownAndUpdateDirection();
        } else {
            return false;
        }
        return true;
    }

    private void goDownAndUpdateDirection() {
        y += 1;
        goRight = !goRight;
    }

    private boolean canGoDown(final int maxX, final int maxY) {
        return y + 1 < maxY && 0 <= x && x < maxX;
    }


    private boolean canGoLeft(final int maxX, final int maxY) {
        return x - 1 >= 0 && 0 <= y && y < maxY;
    }

    private boolean canGoRight(final int maxX, final int maxY) {
        return x + 1 < maxX && 0 <= y && y <maxY;
    }

}
