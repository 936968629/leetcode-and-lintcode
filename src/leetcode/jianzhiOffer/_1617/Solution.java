package leetcode.jianzhiOffer._1617;

public class Solution {

    public int maxSubArray(int[] nums) {
        //[-2,1,-3,4,-1,2,1,-5,4]
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        int res = nums[0];
        for (int i = 2; i < length + 1; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i-1], nums[i-1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
