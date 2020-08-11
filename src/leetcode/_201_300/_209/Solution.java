package leetcode._201_300._209;

public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;

        int right = 0;
        int left = 0;
        int cur = 0;
        int res = Integer.MAX_VALUE;
        while (right < length) {
            cur += nums[right];
            while (cur >= s) {
                res = Math.min(res, right-left+1);
                cur -= nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
