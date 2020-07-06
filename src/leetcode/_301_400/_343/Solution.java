package leetcode._301_400._343;

public class Solution {

    public int integerBreak(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n+1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * dp[i-j], j * (i-j)), dp[i]);
            }
        }
        return dp[n];
    }

}
