package leetcode._001_100._079;

import java.util.Arrays;

public class Solution {


    public boolean exist(char[][] board, String word) {
        int length = word.length();
        if (length == 0) {
            return true;
        }
        int rows = board.length;
        if (rows == 0) {
            return false;
        }
        int cols = board[0].length;
        int index = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (word.charAt(0) == board[i][j]) {
                    visited[i][j] = true;
                    if (dfs(board, word, rows, cols, i, j, index, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int rows, int cols, int i, int j, int index, boolean[][] visited) {
        int[][] coin = {{0,-1}, {-1,0}, {0,1}, {1,0}};

        if (word.length() - 1 <= index) {
            return true;
        }

        for (int k = 0; k < 4; k++) {
            int newI = i + coin[k][0];
            int newJ = j + coin[k][1];

            if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && !visited[newI][newJ] && word.charAt(index+1) == board[newI][newJ]) {
                visited[newI][newJ] = true;
                if (dfs(board, word, rows, cols, newI, newJ, index+1, visited) ) {
                    return true;
                }else {
                    visited[newI][newJ] = false;
                }
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
