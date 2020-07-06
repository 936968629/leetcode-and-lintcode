package leetcode._201_300._213;

public class Solution {

    public int rob(int[] nums) {
        //[2,3,2]
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        // 不打结第一个
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < length + 1; i++) {
            dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
        }
        //打劫第一个 不打结最后一个
        int[] dp2 = new int[length+1];
        dp2[0] = 0;
        dp2[1] = nums[0];
        for (int i = 2; i < length + 1; i++) {
            if (i == length) {
                dp2[i] = dp2[i-1];
            }else {
                dp2[i] = Math.max(nums[i-1] + dp2[i-2], dp2[i-1]);
            }

        }
        return Math.max(dp[length], dp2[length]);
    }

}
