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

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int rows = intervals.length;
        if (rows == 0) {
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res;
        }
        int add = 0;
        for (int i = 0; i < rows; i++) {
            int[] item = intervals[i];
            if (item[1] < newInterval[0]) {
                result.add(item);
            }else if (item[0] > newInterval[1]){
                if (add == 0) {
                    add = 1;
                    result.add(newInterval);
                }
                result.add(item);
            }else {
                newInterval[0] = Math.min(item[0], newInterval[0]);
                newInterval[1] = Math.max(item[1], newInterval[1]);
            }
        }
        if (add == 0) {
            result.add(newInterval);
        }
        return result.toArray(new int[0][]);
    }

}
