package lintcode._920;

import lintcode._001_100._030.Interval;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if ( intervals == null || intervals.size() == 0 ) {
            return true;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

    }

}
