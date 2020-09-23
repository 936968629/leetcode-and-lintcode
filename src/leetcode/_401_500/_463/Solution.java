package leetcode._401_500._463;

public class Solution {

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i-1 >= 0 && grid[i-1][j] == 1) {
                        res -= 2;
                    }
                    if (j - 1 >= 0 && grid[i][j-1] == 1) {
                        res -= 2;
                    }
                }
            }
        }

        return res;
    }

}
