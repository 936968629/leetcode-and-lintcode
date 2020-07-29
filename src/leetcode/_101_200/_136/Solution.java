package leetcode._101_200._136;

public class Solution {

    public int singleNumber(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int res = nums[0];
        for (int i = 1; i < length; i++) {
            res ^= nums[i];
        }
        return res;
    }

}
