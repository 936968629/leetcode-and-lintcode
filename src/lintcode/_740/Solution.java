package lintcode._740;

import java.util.Arrays;

public class Solution {

    public int change(int amount, int[] coins) {
        // write your code here
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= amount; i++) {
                if ( i - coins[j] >= 0 ) {
                    dp[i] += dp[i-coins[j]];
                }
            }
        }
        return  dp[amount];

    }

}
