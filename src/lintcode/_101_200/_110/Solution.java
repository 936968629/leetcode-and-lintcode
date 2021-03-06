package lintcode._101_200._110;

public class Solution {

    public int minPathSum(int[][] grid) {
        // write your code here
        int rows = grid.length;
        if ( rows == 0 ) {
            return 0;
        }
        int cols = grid[0].length;
        for (int i = 1; i < cols; i++) {
            grid[0][i] = grid[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] = Math.min(grid[i-1][j] + grid[i][j], grid[i][j-1] + grid[i][j]);
            }
        }

        return grid[rows-1][cols-1];
    }
}
