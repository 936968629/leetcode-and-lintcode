package leetcode._401_500._416;

public class Solution {


    //思想同0-1背包
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int totalNum = 0;
        for (int i = 0; i < length; i++) {
            totalNum += nums[i];
        }
        if (totalNum % 2 != 0) {
            return false;
        }
        int targetNum = totalNum / 2;
        //选择前i个数 目标和targetNum

        boolean[][] dp = new boolean[length+1][targetNum + 1];
        for (int i = 0; i < length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < targetNum + 1; j++) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[length][targetNum];
    }



}
