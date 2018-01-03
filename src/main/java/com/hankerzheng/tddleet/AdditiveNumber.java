package com.hankerzheng.tddleet;

/**
 *
 * 306. Additive Number
 *
 * Additive number is a string whose digits can form additive sequence.
 *
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 *
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 *
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 *
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 *
 * Follow up:
 * How would you handle overflow for very large input integers?
 *
 * Credits:
 * Special thanks to @jeantimex for adding this problem and creating all test cases.
 *
 */

public class AdditiveNumber {

    /**
     * MY THOUGHT:
     *
     * Recursively find the first two number, then just do the checking. Once find the match, return true.
     * A lot of effort is spent on the trailing zeros.
     *
     * Time Complexity: O(n2)
     * Space Complexity: O(1)
     *
     * @param num
     * @return
     */

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        boolean result = false;
        int maxIdx = num.length() / 2;
        for (int firstPlace = 0; firstPlace < maxIdx; firstPlace++) {
            result = result || findSecondPlace(num, firstPlace);
            if (result) {
                return result;
            }
        }
        return false;
    }

    private boolean findSecondPlace(String num, int firstPlace) {
        int maxIdx = (num.length() - firstPlace) / 2 + firstPlace;
        boolean result = false;
        for (int secondPlace = firstPlace + 1; secondPlace <= maxIdx; secondPlace++) {
             result = result || verifyNumber(firstPlace, secondPlace, num);
             if (result) {
                 return result;
             }
        }
        return false;
    }

    private boolean verifyNumber(int firstPlace, int secondPlace, String num) {
        String numOne = num.substring(0, firstPlace + 1);
        String  numTwo = num.substring(firstPlace + 1, secondPlace + 1);
        int idx = secondPlace + 1;
        while (idx < num.length()) {
            String expected = addTwoString(numOne, numTwo);
            if (expected != null && num.substring(idx).startsWith(expected)) {
                numOne = numTwo;
                numTwo = expected;
                idx += expected.length();
            } else {
                return false;
            }
        }
        return true;
    }

    private String addTwoString(String numOne, String numTwo) {
        boolean trailingZeroOne = numOne.length() > 1 && numOne.startsWith("0");
        boolean trailingZeroTwo = numTwo.length() > 1 && numTwo.startsWith("0");
        if (trailingZeroOne || trailingZeroTwo) {
            return null;
        }
        return String.valueOf(Long.parseLong(numOne) + Long.parseLong(numTwo));
    }


}
