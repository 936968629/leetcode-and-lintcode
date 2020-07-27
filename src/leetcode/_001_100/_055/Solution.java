package leetcode._001_100._055;

import lintcode.ListNode;

public class Solution {

    public boolean canJump(int[] nums) {
        //[2,1,1,1,4]
        //贪心
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        int rightmost = 0;
        for (int i = 0; i < length; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= length - 1) {
                    return true;
                }
            }
        }
        return false;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,1,1,1,3};
        solution.canJump(nums);
    }

}
