package com.hankerzheng.tddleet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextClosestTime {
    public String nextClosestTime(String time) {
        final Set<Integer> digitSet = getAllDigitsFromTime(time);
        final List<Integer> numbers = consturctTwoDigitNumber(digitSet);
        int min = 0;
        int hour = 0;
        for (final int num: numbers) {
            if (isConfrontedToMinConstraint(num, time)) {
                return time.substring(0, 3) + String.valueOf(num);
            }
        }
        for (final int num: numbers) {
            if (isConfrontedToHourConstraint(num, time)) {
                return String.valueOf(num) + time.substring(2);
            }
        }
        return getMinTime(digitSet);
    }

    private String getMinTime(final Set<Integer> digitSet) {
        return null;
    }

    private boolean isConfrontedToMinConstraint(final int num, final String time) {
        return false;
    }

    private List<Integer> consturctTwoDigitNumber(final Set<Integer> digitSet) {
        return null;
    }

    private boolean isConfrontedToHourConstraint(final int num, final String time) {
        return false;
    }

    private String updateMinutes(final String time, final Set<Integer> digitSet) {
        for(int number: constructTwoDigitNumber(digitSet)) {
        }
        return null;
    }

    private int[] constructTwoDigitNumber(final Set<Integer> digitSet) {
        return new int[0];
    }

    private Set<Integer> getAllDigitsFromTime(final String time) {
        final Set<Integer> res = new HashSet<>();
        res.add(time.charAt(0) - '0');
        res.add(time.charAt(1) - '0');
        res.add(time.charAt(3) - '0');
        res.add(time.charAt(4) - '0');
        return res;
    }
}
