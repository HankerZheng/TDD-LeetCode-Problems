package com.hankerzheng.tddleet;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    static class Interval {
        int start;
        int end;

        public Interval(final int start, final int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        int ans = 0;
        for (int i = 0; i < intervals.length; i++) {
            Interval thisTime = intervals[i];
            while (!pq.isEmpty() && pq.peek() <= thisTime.start) {
                pq.remove();
            }
            pq.add(intervals[i].end);
            ans = Math.max(ans, pq.size());
        }
        return ans;
    }
}
