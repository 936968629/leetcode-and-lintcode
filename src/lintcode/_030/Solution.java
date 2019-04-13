package lintcode._030;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        ArrayList<Interval> res = new ArrayList<>();
        if (newInterval == null) {
            return intervals;
        }
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }

        int cur = 0; //保存插入的位置
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (newInterval.end < interval.start) {
                res.add(interval);
            } else if (newInterval.start > interval.end) {
                res.add(interval);
                cur++;
            } else { //有重叠区域的情况
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        //在cur保存插入的位置
        res.add(cur, newInterval);
        return res;
    }

}
