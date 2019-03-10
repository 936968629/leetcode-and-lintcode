package lintcode._005;

import java.util.Arrays;

public class Solution {

    public int kthLargestElement(int n, int[] nums) {
        // write your code here


        int start=0;
        int end=nums.length-1;
        int index=partition(nums, 0, nums.length-1);
        while(index!=nums.length-n){
            if(index>nums.length-n){
                index=partition(nums, start, index-1);
            }else{
                index=partition(nums, index+1, end);
            }
        }
        return nums[index];

    }

    public int partition(int[] nums,int start,int end){
        int left=start;
        int right=end;
        int pivot=nums[start];
        while(left<right){
            while(left<right&&nums[right]>=pivot)
                right--;
            if(left<right){
                nums[left]=nums[right];
                left++;
            }
            while(left<right&&nums[left]<pivot)
                left++;
            if(left<right){
                nums[right]=nums[left];
                right--;
            }
        }
        nums[left]=pivot;
        return left;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 1;
        int[] nums = {1,3,4,2,1};
        sol.kthLargestElement(n, nums);
    }

}
