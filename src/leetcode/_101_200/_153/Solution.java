package leetcode._101_200._153;

public class Solution {

    public int findMin(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int middle = left + (right-left) / 2;
            if (nums[middle] < nums[right]) {
                right = middle;
            }else {
                left = middle;
            }

        }
        return Math.min(nums[left], nums[right]);
    }

}
