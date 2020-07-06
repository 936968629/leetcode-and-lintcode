package leetcode._001_100._035;

public class Solution {

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if ( length == 0 ) {
            return 0;
        }
        int left = 0;
        int right = length - 1;

        while ( left + 1 < right ) {
            int middle = left + (right - left) / 2;
            if ( nums[middle] == target ) {
                right = middle;
            }else if (nums[middle] < target) {
                left = middle;
            }else {
                right = middle;
            }
        }
        if ( nums[left] >= target ) {
            return left;
        }
        if ( nums[right] >= target ) {
            return right;
        }
        return length;
    }

}
