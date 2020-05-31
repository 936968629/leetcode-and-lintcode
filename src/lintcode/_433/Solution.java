package lintcode._433;

public class Solution {

    public int numIslands(boolean[][] grid) {
        // write your code here
        if ( grid == null || grid.length == 0 ) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ( grid[i][j] ) {
                    dfs(grid, rows, cols, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    public void dfs(boolean[][] grid, int rows, int cols, int i, int j) {
        int[][] range = { {0,1},{0,-1},{1,0},{-1,0} };
        for (int k = 0; k < 4; k++) {
            //注意必须用新变量，不能在原来值上改
            int newI = i + range[k][0];
            int newJ = j + range[k][1];
            if ( newI>= 0 && newI < rows && newJ >=0 && newJ < cols && grid[newI][newJ]) {
                grid[newI][newJ] = false;
                dfs(grid, rows, cols, newI, newJ);
            }
        }
    }

}
