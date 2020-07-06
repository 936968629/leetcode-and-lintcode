package leetcode.jianzhiOffer._011;

public class Solution {

    public int minArray(int[] nums) {
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
            }else if (nums[middle] > nums[right]) {
                left = middle;
            }else {
                right--;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
