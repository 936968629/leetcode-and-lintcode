package lintcode._301_400._383;

import java.util.Stack;

public class Solution {

    public int maxArea(int[] heights) {
        // write your code here
        int res = 0;
        int length = heights.length;
        if ( length == 0 ) {
            return 0;
        }
        int i = 0;
        int j = length - 1;
        while ( i < j ) {
            res = Math.max( Math.min(heights[i], heights[j]) * (j-i) , res);
            if ( heights[i] < heights[j] ) {
                i++;
            }else {
                j--;
            }

        }
        return res;
    }

}
