package leetcode.jianzhiOffer._0801;

public class Solution {

    public int waysToStep(int n) {
        if ( n == 1 ) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < n+1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3])%1000000007;
        }
        return (int)dp[n];
    }

}
