package leetcode.jianzhiOffer._053;

public class Solution {

    public int missingNumber(int[] nums) {
        //[0,1,2,3,4,5,6,7,9]
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left + 1 < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == middle) {
                left = middle;
            }else if (nums[middle] > middle) {
                right = middle;
            }else {
                left = middle;
            }
        }
        if (nums[left] > left) {
            return left;
        }
        if (nums[right] > right) {
            return right;
        }
        return length;
    }

}
