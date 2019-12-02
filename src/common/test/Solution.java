package common.test;

import java.util.*;

public class Solution {


    public int findMin(int[] nums) {
        // write your code here
        int length = nums.length;
        if (length == 0){
            return 0;
        }
        int start = 0;
        int end = length - 1;
        while (start + 1 < end){

            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]){
                start = mid;
            }else{
                end = mid;
            }

        }

        if (nums[start] < nums[end]){
            return nums[start];
        }
        return nums[end];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int min = sol.findMin(nums);
        System.out.println(min);
    }

}
