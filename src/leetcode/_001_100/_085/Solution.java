package leetcode._001_100._085;

public class Solution {


    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] == 1 && dp[i-1][j] != 0) {
                    dp[i][j] = dp[i-1][j] + 1;
                }
            }
        }
        int area = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] != 0) {
                    int curHeight = dp[i][j];
                    for (int k = j; k >= 0 ; k--) {
                        int curWeight = j-k+1;
                        curHeight = Math.min(curHeight, dp[i][k]);
                        area = Math.max(area, curHeight * curWeight);
                    }
                }
            }
        }

        return area;
    }

    public static void main(String[] args) {

    }
}
