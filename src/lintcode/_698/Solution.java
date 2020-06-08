package lintcode._698;

public class Solution {

    public int maxDiff(int[][] arrs) {
        // write your code here
        int rows = arrs.length;
        if (rows == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            int size = arrs[i].length;
            min = Math.min(min, arrs[i][0]);
            max = Math.max(max, arrs[i][size-1]);
        }

        return max - min;
    }

}
