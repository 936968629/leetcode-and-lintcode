package leetcode._001_100._057;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int rows = intervals.length;
        if (rows == 0) {
            int[][] res = new int[1][1];
            res[0] = newInterval;
            return res;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        int signal = 0;
        for (int i = 0; i < rows; i++) {
            int[] cur = intervals[i];
            if (cur[1] < newInterval[0]) {
                res.add(cur);
                continue;
            }
            if (newInterval[1] < cur[0]) {
                res.add(newInterval);
                for (int j = i; j < rows; j++) {
                    res.add(intervals[j]);
                }
                signal = 1;
                break;
            }
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
        }
        if (signal == 0) {
            res.add(newInterval);
        }
        return res.toArray(new int[0][]);
    }

}
