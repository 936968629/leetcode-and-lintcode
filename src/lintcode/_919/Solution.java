package lintcode._919;

import lintcode._001_100._030.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    class Time {
        public int time;
        public int cost;
        public Time(int time, int cost) {
            this.cost = cost;
            this.time = time;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if ( intervals == null || intervals.size() == 0 ) {
            return 0;
        }
        int res = 0;

        List<Time> times = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            times.add(new Time(interval.start, 1));
            times.add(new Time(interval.end, -1));
        }

        Collections.sort(times, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if ( o1.time == o2.time ) {
                    return o1.cost - o2.cost;
                }
                return o1.time - o2.time;
            }
        });
        int temp = 0;
        for (int i = 0; i < times.size(); i++) {
            Time time = times.get(i);
            if ( time.cost == 1 ) {
                temp++;
            } else {
                temp--;
            }
            res = Math.max(res, temp);
        }
        return res;
    }

}
