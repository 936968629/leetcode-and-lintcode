package lintcode._860;

import java.util.Arrays;

public class Solution {

    boolean[][] visited = null;

    int[][] dir = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};

    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        int rows = grid.length;
        if (rows == 0){
            return 0;
        }
        int cols = grid[0].length;
        int count = 0;

        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]){
                    dfs(grid, i, j, rows, cols);
                    count++;
                }
            }
        }

        System.out.println(count);
        return count;
    }

    public void dfs(int[][] grid, int i, int j, int rows, int cols){
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int[] item = dir[k];
            i = i + item[0];
            j = j + item[1];
            if (i>= 0 && i < rows && j>= 0 && j < cols && grid[i][j] == 1 && !visited[i][j]){
                dfs(grid, i, j, rows, cols);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{1,1,0,0,1},{1,0,0,0,0},{1,1,0,0,1},{0,1,0,1,1}};
        solution.numberofDistinctIslands(grid);
    }

}
