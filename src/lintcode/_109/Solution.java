package lintcode._109;

import java.util.Arrays;
import java.util.Collections;

public class Solution {


    public int minimumTotal(int[][] triangle) {
        // write your code here

        int rows = triangle.length;
        if (rows == 0){
            return 0;
        }
        if (rows == 1){
            return triangle[0][0];
        }
        int cols = triangle[rows-1].length;
        int[] dp = new int[cols];
        for (int i = 0; i < cols; i++) {
            dp[i] = triangle[rows-1][i];
        }
        for (int i = rows - 2; i >= 0; i--) {

            int col = triangle[i].length;
            for (int j = 0; j < col; j++) {
                dp[j] = Math.min(dp[j]+triangle[i][j], dp[j+1]+triangle[i][j]);
            }

        }

        return dp[0];

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] tr = {
                {-1},
                {2,3},
                {1,-1,-3}
        };
        System.out.println(sol.minimumTotal(tr));
    }

}
