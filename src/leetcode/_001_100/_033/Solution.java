package leetcode._001_100._033;

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
                return mid;
            }
            if (nums[mid] < nums[right]) {
                if (nums[mid] <= target && target <= nums[right]){
                    left = mid;
                }else{
                    right = mid;
                }
            }else {
                if (nums[left] <= target && target <= nums[mid]){
                    right = mid;
                }else{
                    left = mid;
                }
            }
        }

        if ( nums[left] == target ){
            return left;
        }
        if ( nums[right] == target ){
            return right;
        }
        return -1;
    }

}
