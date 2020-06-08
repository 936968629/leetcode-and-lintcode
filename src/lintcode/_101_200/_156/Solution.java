package lintcode._101_200._156;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0){
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval prev = null;
        for(Interval interval : intervals){
            if (prev == null || prev.end < interval.start){
                res.add(interval);
                prev = interval;
            } else{
                Interval item = res.get(res.size()-1);
                item.end = Math.max(item.end, interval.end);
                res.set(res.size()-1, item);
                prev = item;
            }
        }

        return res;
    }
}
