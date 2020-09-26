package leetcode._1288;

import java.util.Arrays;

public class Solution {

    public int removeCoveredIntervals(int[][] intervals) {
        int rows = intervals.length;
        if (rows == 0 || rows == 1) {
            return rows;
        }
        //起点升序 相同则降序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int[][] result = new int[rows][2];
        int res = 0;
        int[] prev = intervals[0];
        for (int i = 1; i < rows; i++) {
            int[] item = intervals[i];
            if (prev[0] <= item[0] && prev[1] >= item[1]) {
                //覆盖
                res++;
            }else if (prev[1] < item[0]){
//                res++;
                prev[0] = item[0];
                prev[1] = item[1];
            }else {
//                res++;
                prev[1] = Math.max(prev[1], item[1]);
            }
        }
        return rows - res;
    }

}
