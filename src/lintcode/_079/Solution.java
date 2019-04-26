package lintcode._079;

import java.util.Arrays;

public class Solution {

    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A.length()==0 || B.length()==0) {
            return 0;
        }

        int[][] dp=new int[A.length()][B.length()];
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                dp[i][j] = 0;
            }
        }

        int maxLength = 0;

        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)){
                    if( i > 0 && j > 0){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else{
                        dp[i][j] = 1;
                    }
                }
                maxLength = Math.max(dp[i][j], maxLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String A = "abcd";
        String B = "ac";
        sol.longestCommonSubstring(A, B);
    }
}
