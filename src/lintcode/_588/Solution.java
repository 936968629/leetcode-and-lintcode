package lintcode._588;

public class Solution {

    public boolean canPartition(int[] nums) {
        // write your code here
        int length = nums.length;
        if (length == 0){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0 ){
            return false;
        }
        sum = sum / 2;

        boolean[] dp = new boolean[sum + 1];
        for (int i = 0; i <=sum ; i ++) {
            dp[i] = false;
        }
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            for (int j = sum; j >= nums[i] ; j--) {
                dp[j] |= dp[j-nums[i]];
            }
        }
        return dp[sum];
    }

}
