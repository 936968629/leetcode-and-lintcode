package leetcode._101_200._162;

public class Solution {

    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return 0;
        }
        int left = 0;
        int right = length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]) {
                left = mid;
            }else if (nums[mid] < nums[mid-1] && nums[mid] > nums[mid+1]) {
                right = mid;
            }else if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }else {
                left = mid;
            }
        }
        if (nums[left]>nums[right]){
            return left;
        }
        return right;
    }

}
