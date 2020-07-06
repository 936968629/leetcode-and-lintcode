package leetcode._101_200._198;

public class Solution {

    public int rob(int[] nums) {
        //[8,2,1,8]
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        // dp[i] 前i个房子偷的最大值
//        int[] dp = new int[length+1];
//        dp[0] = 0;
//        dp[1] = nums[0];
//        for (int i = 2; i < length + 1; i++) {
//            dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
//        }
//        return dp[length];
        
        int prev = 0;
        int cur = nums[0];
        for (int i = 0; i < length; i++) {
            int temp = Math.max(prev+nums[i], cur);
            prev = cur;
            cur = temp;
        }
        return cur;
    }

}
