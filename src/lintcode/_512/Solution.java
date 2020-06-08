package lintcode._512;

public class Solution {

    public int numDecodings(String s) {
        // write your code here
        int length = s.length();
        if (length == 0){
            return 0;
        }

        int[] dp = new int[length+1];
        dp[0] = 0;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= length; i++) {
            if (s.charAt(i-1) != '0'){
                dp[i] = dp[i-1];
            }
            if (Integer.valueOf(s.substring(i-2, i)) <= 26 && Integer.valueOf(s.substring(i-2, i)) >= 10){
                dp[i] += dp[i-2];
            }
        }
        return dp[length];
    }



}
