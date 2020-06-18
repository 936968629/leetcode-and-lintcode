package lintcode._001_100._029;

public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int lenS1 = s1.length();
        int lenS2 = s2.length();
        int lenS3 = s3.length();
        if ( lenS1 + lenS2 != lenS3 ) {
            return false;
        }
        boolean[][] dp = new boolean[lenS1+1][lenS2+1];
        dp[0][0] = true;
        for (int i = 1; i < lenS1 + 1; i++) {
            if ( s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0] ) {
                dp[i][0] = true;
            }
        }
        for (int i = 1; i < lenS2 + 1; i++) {
            if ( s2.charAt(i-1) == s3.charAt(i-1) && dp[0][i-1] ) {
                dp[0][i] = true;
            }
        }

        for (int i = 1; i < lenS1 + 1; i++) {
            for (int j = 1; j < lenS2 + 1; j++) {
                if ( (s3.charAt(i+j-1) == s1.charAt(i-1) && dp[i-1][j]) ||
                        (s3.charAt(i+j-1) == s2.charAt(j-1) && dp[i][j-1])
                ) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[lenS1][lenS2];
    }

}
