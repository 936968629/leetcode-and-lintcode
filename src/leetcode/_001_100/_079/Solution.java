package leetcode._001_100._079;

import java.util.Arrays;

public class Solution {


    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        if (rows == 0) {
            return word.length() == 0 ? true : false;
        }
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(board, word, i, j, 0, visited, rows, cols)) {
                        return true;
                    }
                    visited[i][j] = false;
                }

            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited, int rows, int cols) {
        if (index == word.length() - 1) {
            return true;
        }
        int[][] coin = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        for (int k = 0; k < 4; k++) {
            int newI = coin[k][0] + i;
            int newJ = coin[k][1] + j;
            if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && board[newI][newJ] == word.charAt(index+1) && !visited[newI][newJ]) {
                visited[newI][newJ] = true;
                if (dfs(board, word, newI, newJ, index+1, visited, rows, cols)) {
                    return true;
                }
                visited[newI][newJ] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};

        System.out.println(solution.exist(board, "AADSF"));

    }
}
