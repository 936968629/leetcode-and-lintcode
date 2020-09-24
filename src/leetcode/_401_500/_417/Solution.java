package leetcode._401_500._417;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = matrix.length;
        if (rows == 0) {
            return result;
        }
        int cols = matrix[0].length;

        boolean[][] canReachT = new boolean[rows][cols];
        boolean[][] canreachD = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, rows, cols, canReachT, matrix);
            dfs(i, cols-1, rows, cols, canreachD, matrix);
        }

        for (int i = 0; i < cols; i++) {
            dfs(0, i, rows, cols, canReachT, matrix);
            dfs(rows-1, i, rows, cols, canreachD, matrix);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canreachD[i][j] && canReachT[i][j]) {
                    List<Integer> item = new ArrayList<>();
                    item.add(i);
                    item.add(j);
                    result.add(item);
                }
            }
        }
        return result;
    }

    public void dfs(int i, int j, int rows, int cols, boolean[][] canReach, int[][] matrix) {
        canReach[i][j] = true;
        int[][] grid = {{0,-1}, {-1, 0}, {1,0}, {0,1}};
        for (int k = 0; k < 4; k++) {
            int newI = i + grid[k][0];
            int newJ = j + grid[k][1];
            if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && matrix[i][j] <= matrix[newI][newJ] && !canReach[newI][newJ]) {
                dfs(newI, newJ, rows, cols, canReach, matrix);
            }
        }
    }

}
