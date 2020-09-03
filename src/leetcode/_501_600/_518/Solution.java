package leetcode._501_600._518;

public class Solution {

    public int change(int amount, int[] coins) {
        int length = coins.length;
        // 凑到i 有dp[i]种方法
        int[] dp = new int[amount + 1];

        // base case
        dp[0] = 1;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]) {
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }

        return dp[amount];
    }

}
