package leetcode.jianzhiOffer._042;

public class Solution {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if ( length == 0 ) {
            return 0;
        }
        if ( length == 1 ) {
            return nums[0];
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        int res = nums[0];
        for (int i = 2; i < length + 1; i++) {
            dp[i] = Math.max(nums[i-1], nums[i-1] + dp[i-1]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
