package leetcode._001_100._044;

public class Solution {

    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        if (pLength == 0 && s.length() == 0) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }

        // 前i,前j个 是否匹配
        boolean[][] dp = new boolean[sLength+1][pLength+1];
        dp[0][0] = true;
        for (int i = 1; i < pLength + 1; i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = true;
            }else {
                break;
            }
        }

        for (int i = 1; i < sLength + 1; i++) {
            for (int j = 1; j < pLength + 1; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }

        return dp[sLength][pLength];
    }

}
