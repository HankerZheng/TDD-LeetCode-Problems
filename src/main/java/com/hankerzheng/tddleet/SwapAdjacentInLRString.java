package com.hankerzheng.tddleet;

/**
 * 777. Swap Adjacent in LR String
 *
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL",
 * a move consists of either replacing one occurrence of "XL" with "LX",
 * or replacing one occurrence of "RX" with "XR".
 *
 * Given the starting string start and the ending string end,
 * return True if and only if there exists a sequence of moves to transform one string to the other.
 *
 */

public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        int endIdx = 0; // always points to the position that has not been visited

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                // findAndVerifyLeft
                while (endIdx <= i) {
                    if (end.charAt(endIdx) == 'L') {
                        endIdx++;
                        break;
                    } else if (end.charAt(endIdx) == 'R') return false;
                    endIdx ++;
                }
                if (end.charAt(endIdx - 1) != 'L') return false;
            } else if (start.charAt(i) == 'R') {
                // findAndVerifyRight
                while (endIdx < i) {
                    if (end.charAt(endIdx) != 'X') return false;
                    endIdx++;
                }
                while (endIdx < end.length()) {
                    if (end.charAt(endIdx) == 'R') {
                        endIdx ++;
                        break;
                    }
                    else if (end.charAt(endIdx) == 'L') return false;
                    endIdx++;
                }
                if (end.charAt(endIdx - 1) != 'R') return false;
            }
        }
        return isAllXAfter(endIdx, end);
    }

    private boolean isAllXAfter(final int endIdx, final String end) {
        for (int i = endIdx; i < end.length(); i++) {
            if (end.charAt(i) != 'X') {
                return false;
            }
        }
        return true;
    }
}
