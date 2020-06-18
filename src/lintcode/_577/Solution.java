package lintcode._577;

import lintcode._001_100._030.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here
        List<Interval> arr = new ArrayList();
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = 0; j < intervals.get(i).size(); j++) {
                arr.add(intervals.get(i).get(j));
            }
        }
        if ( arr == null || arr.size() == 0 ) {
            return new ArrayList<>();
        }
        Collections.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> result = new ArrayList();
        result.add(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            Interval interval = arr.get(i);
            Interval prev = result.get(result.size() - 1);
            if ( prev.end < interval.start ) {
                result.add(interval);
            } else {
                prev.end = Math.max(prev.end, interval.end);
            }
        }
        return result;
    }

}
