package leetcode._101_200._174;

public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        if (rows == 0) {
            return 0;
        }
        int cols = dungeon[0].length;
        int[][] dp = new int[rows+1][cols+1];
        for (int i = 0; i < rows; i++) {
            dp[i][cols] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < cols; i++) {
            dp[rows][i] = Integer.MAX_VALUE;
        }
        dp[rows][cols-1] = 0;
        dp[rows-1][cols] = 0;
        for (int i = rows-1; i >= 0; i--) {
            for (int j = cols -1; j >= 0; j--) {
                dp[i][j] = Math.max(0, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
            }
        }
        return dp[0][0] + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] sum ={{-2,-3,3},{-5,-10,1},{10,30,-5}};
        solution.calculateMinimumHP(sum);
    }

}
