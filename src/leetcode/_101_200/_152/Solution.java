package leetcode._101_200._152;

public class Solution {

    public int maxProduct(int[] nums) {
        //[-2,3,-4]
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dpMax = new int[length+1];
        int[] dpMin = new int[length+1];
        dpMax[0] = dpMin[0] = 0;
        dpMax[1] = dpMin[1] = nums[0];
        int res = nums[0];
        for (int i = 2; i < length + 1; i++) {
            dpMax[i] = Math.max(dpMax[i-1] * nums[i-1], Math.max(dpMin[i-1]*nums[i-1], nums[i-1]));
            dpMin[i] = Math.min(dpMin[i-1] * nums[i-1],Math.min(dpMax[i-1]*nums[i-1], nums[i-1]));
            res = Math.max(res, dpMax[i]);
        }
        return res;
    }

}
