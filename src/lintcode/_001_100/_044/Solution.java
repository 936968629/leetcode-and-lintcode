package lintcode._001_100._044;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public int minSubArray(List<Integer> nums) {
        // write your code here
        int length = nums.size();
        if ( length == 0 ) {
            return 0;
        }

        int[] dp = new int[length];
        dp[0] = nums.get(0);
        for (int i = 1; i < length; i++) {
            dp[i] = Math.min(dp[i-1] + nums.get(i), nums.get(i));
        }

        return Arrays.stream(dp).min().getAsInt();
    }

}
