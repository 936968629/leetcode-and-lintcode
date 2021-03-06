package leetcode._101_200._200;

public class Solution {

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, rows, cols);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid,int row, int col, int rows, int cols) {

        int[][] signal = {{0,1},{1,0},{-1,0},{0,-1}};
        for (int i = 0; i < 4; i++) {
            int newI = row + signal[i][0];
            int newJ = col + signal[i][1];
            if (0<=newI && newI<rows && newJ>=0 && newJ < cols && grid[newI][newJ] == '1') {
                grid[newI][newJ] = '0';
                dfs(grid, newI, newJ, rows, cols);
            }
        }
    }

}
