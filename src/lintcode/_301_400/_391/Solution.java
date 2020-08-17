package lintcode._301_400._391;

import lintcode._001_100._030.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    class Time {
        public int time;
        public int flag;

        public Time(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }

    }

    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if ( airplanes == null || airplanes.size() == 0 ) {
            return 0;
        }
        List<Time> times = new ArrayList<>();
        for (int i = 0; i < airplanes.size(); i++) {
            Interval interval = airplanes.get(i);
            times.add(new Time(interval.start, 1));
            times.add(new Time(interval.end, 0));
        }

        Collections.sort(times, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if ( o1.time == o2.time ) {
                    return o1.flag - o2.flag;
                }
                return o1.time - o2.time;
            }
        });

        int res = 0;
        int count = 0;
        for (int i = 0; i < times.size(); i++) {
            Time time = times.get(i);
            if ( time.flag == 1 ) {
                count++;
            } else {
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public int countOfAirplanes2(List<Interval> airplanes) {
        // write your code here
//        int length = airplanes.size();
//        if (length == 0) {
//            return 0;
//        }
//        Collections.sort(airplanes, (o1,o2) -> {
//            return o1.end - o2.end;
//        });
//
//        int prevEnd = airplanes.get(0).end;
//        int res = 1;
//        for (int i = 1; i < length; i++) {
//            Interval item = airplanes.get(i);
//            if (item.start <= prevEnd) {
//                res++;
//                prevEnd = item.end;
//            }
//        }
//        return res;
        return -1;
    }
}
