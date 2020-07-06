package leetcode._1143;

public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        if (length1 == 0 || length2 == 0) {
            return 0;
        }
        int[][] dp = new int[length1+1][length2+1];
        for (int i = 0; i < length1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < length2; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < length1+1; i++) {
            for (int j = 1; j < length2+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[length1][length2];
    }

}
