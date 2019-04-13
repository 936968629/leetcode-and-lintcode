package common.test;

import java.util.*;

public class Solution {


    public int findMin(int[] nums) {
        // write your code here
        if (nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right-1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int min = sol.findMin(nums);
        System.out.println(min);
    }

}