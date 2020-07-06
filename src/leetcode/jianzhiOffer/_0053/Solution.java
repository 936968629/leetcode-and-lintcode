package leetcode.jianzhiOffer._0053;

public class Solution {

    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int left = 0;
        int right = length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            }else if (nums[mid] > target) {
                right = mid;
            }else {
                left = mid;
            }
        }

        int res = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                res++;
            }
        }
        return res;
    }

}
