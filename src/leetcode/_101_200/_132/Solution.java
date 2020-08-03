package leetcode._101_200._132;

public class Solution {

    public int minCut(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 0;
        }
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i+1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j) && (dp[i+1][j-1] || j - i < 2)) {
                    dp[i][j] = true;
                }
            }
        }
        //[0,i]最少分割次数
        int[] dp2 = new int[length];
        for (int i = 0; i < length; i++) {
            dp2[i] = i;
        }
        for (int i = 1; i < length; i++) {
            if (dp[0][i]) {
                dp2[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j+1][i]) {
                    dp2[i] = Math.min(dp2[i], dp2[j]+1);
                }
            }
        }

        return dp2[length-1];
    }

}
