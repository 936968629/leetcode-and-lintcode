package lintcode._534;

public class Solution {

    public int houseRobber2(int[] nums) {
        // write your code here
        int length = nums.length;
        if ( length == 0 ) {
            return 0;
        }
        if ( length == 1 ) {
            return nums[0];
        }
        //打劫第一个
        int[] dp1 = new int[length+1];
        dp1[0] = 0;
        dp1[1] = nums[0];
        for (int i = 2; i < length+1; i++) {
            if ( i == length ) {
                dp1[i] = dp1[i-1];
            }
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+nums[i-1]);
        }
        //不打劫第一个
        int[] dp2 = new int[length+1];
        dp2[0] = 0;
        dp2[1] = 0;
        for (int i = 2; i < length + 1; i++) {
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+nums[i-1]);
        }
        return Math.max(dp1[length], dp2[length]);
    }

}
