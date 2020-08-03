package leetcode._001_100._045;

public class Solution {

    public int jump(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }

        int most = 0;
        int res = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            most = Math.max(most, i + nums[i]);
            if (end == i) {
                res++;
                end = most;
            }
        }
        return res;
    }

}
