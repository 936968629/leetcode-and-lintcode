package leetcode._201_300._287;

public class Solution {

    public int findDuplicate(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int left = 1;
        int right = length - 1;
        while (left + 1 < right) {
            int middle = left + (right - left) / 2;
            if ( count(nums, middle) <= middle ) {
                left = middle;
            } else {
                right = middle;
            }
        }
        if ( count(nums, left) <= left) {
            return right;
        }
        return left;
    }

    public int count(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] <= target ) {
                count++;
            }
        }
        return count;
    }

}
