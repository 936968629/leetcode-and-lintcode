package leetcode._401_500._452;

import java.util.Arrays;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        int rows = points.length;
        if (rows == 0) {
            return 0;
        }

        Arrays.sort(points, (int[] o1, int[] o2) -> {
            return o1[1] - o2[1];
        });

        int prev_end = points[0][1];
        int res = 1;
        for (int i = 1; i < rows; i++) {
            int[] item = points[i];
            if (item[0] > prev_end) {
                res++;
                prev_end = item[1];
            }
        }

        return res;
    }

}
