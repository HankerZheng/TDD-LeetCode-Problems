package com.hankerzheng.google.interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class CleanRobot implements Robot {

    public static final int[] TRAVERSE_SEQ = {0, 1, 0, -1, 0};
    public static final int FACE_UP = 0;
    public static final int FACE_RIGHT = 1;
    public static final int FACE_DOWN = 2;
    public static final int FACE_LEFT = 3;

    private Position2D curPosi;
    private int curFacing;

    @Override
    public abstract boolean move();

    @Override
    public abstract void clean();

    @Override
    public abstract void turnLeft(final int k);

    @Override
    public abstract void turnRight(final int k);


    public void cleanRoomInit() {
        curFacing = FACE_UP;
        curPosi = Position2D.of(0, 0);
        final LinkedList<Position2D> stack = new LinkedList<>();
        final Map<Position2D, Position2D> parentMapping = new HashMap<>();
        initMemo(stack, parentMapping);
        clean();

        while (!stack.isEmpty()) {
            final Position2D nextPosi = stack.removeLast();
            if (parentMapping.containsKey(nextPosi)) {
                continue;
            }
            moveToNearestVisitedPosiAndFaceNextPosi(nextPosi, parentMapping);
            if (move()) {
                parentMapping.put(nextPosi, curPosi);
                updateCurPosiAfterMove();
                clean();
                pushUnvisitedPosiAroundIntoMemo(stack, parentMapping);
            }
        }
    }

    private void updateCurPosiAfterMove() {
        curPosi = getPositionAhead(curPosi, curFacing);
    }

    // push left, down, right, up into the stack
    private void initMemo(final LinkedList<Position2D> stack, final Map<Position2D, Position2D> parentMapping) {
        int facing = 3;
        for (int i = 4; i > 0; i--) {
            stack.addLast(getPositionAhead(curPosi, facing + i));
        }
        parentMapping.put(curPosi, null);
    }


    // a thin wall can exist
    private void moveToNearestVisitedPosiAndFaceNextPosi(final Position2D endPosi, final Map<Position2D, Position2D> parentMapping) {
        while (!curPosi.nextTo(endPosi)) {
            final Position2D nextPosi = parentMapping.get(curPosi);
            faceToNextPosi(nextPosi);
            if (move()) {
                updateCurPosiAfterMove();
            }
        }
        faceToNextPosi(endPosi);
    }

    // check ahead first, and then clock-wise
    private void faceToNextPosi(final Position2D nextPosi) {
        for (int i = 0; i < 4; i++) {
            final Position2D posiAhead = getPositionAhead(curPosi, curFacing);
            if (posiAhead.equals(nextPosi)) {
                return;
            }
            turnRight(1);
            curFacing = (curFacing + 1) % 4;
        }
    }

    // check left, check right, check ahead;
    private void pushUnvisitedPosiAroundIntoMemo(final LinkedList<Position2D> stack, final Map<Position2D, Position2D> parentMapping) {
        int leftFacing = (curFacing + 3) % 4;
        checkFacingPosition(leftFacing, stack, parentMapping);
        int rightFacing = (curFacing + 1) % 4;
        checkFacingPosition(rightFacing, stack, parentMapping);
        checkFacingPosition(curFacing, stack, parentMapping);
    }

    private void checkFacingPosition(final int facing, final LinkedList<Position2D> stack, final Map<Position2D, Position2D> parentMapping) {
        final Position2D posiAhead = getPositionAhead(curPosi, facing);
        if (!parentMapping.containsKey(posiAhead)) {
            stack.addLast(posiAhead);
        }
    }

    private Position2D getPositionAhead(final Position2D posi, final int facing) {
        int validFacing = facing % 4;
        return Position2D.of(posi.getX() + TRAVERSE_SEQ[validFacing], posi.getY() + TRAVERSE_SEQ[validFacing + 1]);
    }

}
