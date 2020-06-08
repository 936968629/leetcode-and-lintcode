package lintcode._001_100._077;

public class Solution {

    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if ( A.charAt(i-1) == B.charAt(j-1) ) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
        return dp[m][n];
    }
}
