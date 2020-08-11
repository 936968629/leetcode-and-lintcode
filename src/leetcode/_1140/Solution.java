package leetcode._1140;

public class Solution {

    class Command {

        public int first;
        public int second;

        public Command(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }

    public int stoneGameII(int[] piles) {
        int length = piles.length;
        if (length == 0) {
            return 0;
        }

        Command[][] dp = new Command[length][length];
        // base case
        for (int i = 0; i < length; i++) {
            dp[i][i] = new Command(piles[i], 0);
        }

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                // 先手 选左边
                int leftNum = piles[i] + dp[i+1][j].second;
                // 先手选右边
                int rightNum = piles[j] + dp[i][j-1].second;
                if (leftNum > rightNum) {
                    // 选左边
                    int secLeft = dp[i+1][j].first;
                    dp[i][j] = new Command(leftNum, secLeft);
                }else {
                    int secRight = dp[i][j-1].first;
                    dp[i][j] = new Command(rightNum, secRight);
                }
            }
        }

        return dp[0][length-1].first;
    }

    public static void main(String[] args) {

    }

}
