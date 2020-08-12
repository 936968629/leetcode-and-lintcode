package leetcode._401_500._435;

import java.util.Arrays;

public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - find(intervals);
    }

    public int find(int[][] intervals) {
        int rows = intervals.length;
        if (rows == 0) {
            return 0;
        }
        Arrays.sort(intervals, (int[] o1, int[] o2) -> {
            return o1[1] - o2[1];
        });
        int prev = intervals[0][1];
        int res = 1;
        for (int i = 0; i < intervals.length; i++) {
            int[] item = intervals[i];
            if (item[0] >= prev) {
                res++;
                prev = item[1];
            }
        }
        return res;
    }

}
