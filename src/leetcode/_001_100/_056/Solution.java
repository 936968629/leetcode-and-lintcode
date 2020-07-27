package leetcode._001_100._056;

import lintcode._001_100._030.Interval;

import java.util.*;

public class Solution {

    public int[][] merge(int[][] intervals) {
        int rows = intervals.length;
        if (rows == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < rows; i++) {
            int[] cur = intervals[i];
            if (prev[1] < cur[0]) {
                res.add(prev);
                prev = cur;
            }else {
                prev[1] = Math.max(prev[1], cur[1]);
            }
        }
        res.add(prev);
        return res.toArray(new int[0][]);
    }

    public List<Interval> merge(List<Interval> intervals) {
        int size = intervals.size();
        if (size == 0) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> result = new ArrayList<>();
        Interval prev = intervals.get(0);
        for (int i = 1; i < size; i++) {
            Interval cur = intervals.get(i);
            if (prev.end < cur.start) {
                result.add(prev);
                prev = cur;
            }else {
                prev.end = Math.max(prev.end, cur.end);
            }
        }
        result.add(prev);
        return result;
    }
}
