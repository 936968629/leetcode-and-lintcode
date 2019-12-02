package lintcode._115;

import java.util.Arrays;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code
        int rows = obstacleGrid.length;
        if ( rows == 0 ) {
            return 0;
        }
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        if ( obstacleGrid[0][0] == 1 ) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }
        for (int i = 1; i < cols; i++) {
            if ( obstacleGrid[0][i] == 1 ) {
                dp[0][i] = 0;
            }else {
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int i = 1; i < rows; i++) {
            if ( obstacleGrid[i][0] == 1 ) {
                dp[i][0] = 0;
            }else {
                dp[i][0] = dp[i-1][0];
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if ( obstacleGrid[i][j] == 1 ) {
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }

            }
        }
        
        return dp[rows-1][cols-1];
//        System.out.println(Arrays.deepToString(dp));
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ss = new int[2][2];
        solution.uniquePathsWithObstacles(ss);
    }

}
