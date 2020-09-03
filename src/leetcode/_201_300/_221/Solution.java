package leetcode._201_300._221;

public class Solution {

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int res = 0;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    res = 1;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (dp[i][j] != 0) {
                    int min = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]);
                    dp[i][j] = min + 1;
                    res = Math.max(res, dp[i][j] * dp[i][j]);
                }
            }
        }
        return res;
    }

}
