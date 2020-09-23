package leetcode._001_100._010;

public class Solution {

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for (int i = 1; i < pLen + 1; i++) {
            if (p.charAt(i-1) == '*' && dp[0][i-2]) {
                dp[0][i] = dp[0][i-2];
            }
        }
        for (int i = 1; i < sLen + 1; i++) {
            for (int j = 1; j < pLen + 1; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1) == '*') {
                    if (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.') {
                        dp[i][j] = dp[i-1][j-2] || dp[i][j-2] || dp[i-1][j];
                    }else {
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }

        return dp[sLen][pLen];
    }

}
