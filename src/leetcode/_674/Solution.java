package leetcode._674;

import java.util.Arrays;

public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        //[1,3,5,4,7]
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int res= 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

}
