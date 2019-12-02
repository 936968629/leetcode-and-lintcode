package lintcode._116;

public class Solution {

    public boolean canJump(int[] A) {
        // write your code her

        int length = A.length;
        if ( length == 0 ) {
            return true;
        }
        //dp[i]表示能否跳到i这个点
        boolean[] dp = new boolean[length];
        dp[0] = true;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + A[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length-1];
    }

}
