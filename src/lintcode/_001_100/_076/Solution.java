package lintcode._001_100._076;

import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int length = nums.length;
        if ( length == 0 ) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if ( nums[i] > nums[j] ) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {

    }
}
