package leetcode._101_200._130;

public class Solution {

    public void solve(char[][] board) {
        int rows = board.length;
        if (rows <= 2) {
            return;
        }
        int cols = board[0].length;
        //第一行
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                dfs(board, rows, cols, 0, i);
            }
            if (board[rows-1][i] == 'O') {
                dfs(board, rows, cols, rows-1, i);
            }
        }

        //第一列
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, rows, cols, i, 0);
            }
            if (board[i][cols-1] == 'O') {
                dfs(board, rows, cols, i, cols-1);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                    continue;
                }
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int rows, int cols, int row, int col) {
        int[][] map = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        board[row][col] = 'Y';
        for (int i = 0; i < map.length; i++) {
            int newI = row + map[i][0];
            int newJ = col + map[i][1];
            if (0 <= newI && newI < rows && 0 <= newJ && newJ < cols && board[newI][newJ] == 'O') {
                dfs(board, rows, cols, newI, newJ);
            }
        }
    }

    public static void main(String[] args) {
        char[][] nums = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        Solution solution = new Solution();
        solution.solve(nums);
    }
}
