package lintcode._553;

public class Solution {

    public int maxKilledEnemies(char[][] grid) {
        // write your code here
        int rows = grid.length;
        if (rows == 0){
            return 0;
        }
        int res = 0;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0'){
                    int count = find(grid,i,j,rows,cols);
                    res = Math.max(count, res);
                }
            }
        }
        return res;
    }

    public int find(char[][] grid, int i, int j, int rows, int cols){
        int count = 0;
        for (int k = j; k < cols; k++) {
            if (grid[i][k] == 'E'){
                count++;
            }
            if (grid[i][k] == 'W'){
                break;
            }
        }
        for (int k = j; k >= 0 ; k--) {
            if (grid[i][k] == 'E'){
                count++;
            }
            if (grid[i][k] == 'W'){
                break;
            }
        }

        for (int k = i; k < rows; k++) {
            if (grid[k][j] == 'E'){
                count++;
            }
            if (grid[k][j] == 'W'){
                break;
            }
        }
        for (int k = i; k >= 0; k--) {
            if (grid[k][j] == 'E'){
                count++;
            }
            if (grid[k][j] == 'W'){
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {
                {'0','E','0','0'},
                {'E','0','W','E'},
                {'0','E','0','0'}
        };
        solution.maxKilledEnemies(grid);
    }
}
