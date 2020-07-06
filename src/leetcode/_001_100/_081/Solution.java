package leetcode._001_100._081;

public class Solution {

    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

}
