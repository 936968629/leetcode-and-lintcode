package leetcode._301_400._329;

public class Solution {

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int res = 0;
        int cols = matrix[0].length;
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int length = dfs(matrix, rows, cols, i, j, visited);
                res = Math.max(res, length);
            }
        }

        return res;
    }

    public int dfs(int[][] matrix, int rows, int cols, int i, int j, int[][] visited) {

        if (visited[i][j] != 0) {
            return visited[i][j];
        }
        int item = matrix[i][j];
        int max = 1;
        if (i+1 >= 0 && i + 1 < rows && matrix[i+1][j] > item ) {
            max = Math.max(max, 1 + dfs(matrix, rows, cols, i+1, j, visited));
        }
        if (i-1 >= 0 && i - 1 < rows && matrix[i-1][j] > item) {
            max = Math.max(max, 1 + dfs(matrix, rows, cols, i-1, j, visited));
        }
        if (j + 1 >= 0 && j+1 < cols && matrix[i][j+1] > item) {
            max = Math.max(max, 1 + dfs(matrix, rows, cols, i, j+1, visited));
        }
        if (j-1 >= 0 && j - 1 < cols && matrix[i][j-1] > item ) {
            max = Math.max(max, 1 + dfs(matrix, rows, cols, i, j-1, visited));
        }
        visited[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mastrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        solution.longestIncreasingPath(mastrix);
    }
}
