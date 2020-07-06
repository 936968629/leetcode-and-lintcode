package leetcode._523;

public class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sign = sum[j] - sum[i] + nums[i];
                if ( sign == k || (k != 0 && sign % k == 0) ) {
                    return true;
                }
            }
        }
        return false;
    }
}
