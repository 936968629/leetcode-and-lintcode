package lintcode._001_100._014;

public class Solution {
    public int sign = -1;
    public int binarySearch(int[] nums, int target) {
        // write your code here
        //非递归
//        if(nums.length ==0){
//            return -1;
//        }
//        int sign = -1;
//        int left = 0;
//        int right = nums.length;
//        while ( left + 1 < right ) {
//            int mid = left + (right - left) / 2;
//            if ( nums[mid] == target ) {
//                right = mid;
//            }else if ( nums[mid] < target ) {
//                left = mid;
//            }else {
//                right = mid;
//            }
//        }
//        if ( nums[left] == target ) {
//            return left;
//        }
//        if ( nums[right] == target ) {
//            return right;
//        }
//        return -1;
        //递归
        if (nums.length == 0){
            return -1;
        }
        helper(nums, 0, nums.length, target);
        return sign;
    }

    public void helper(int[] nums, int left, int right, int target){

        if (left >= right){
            return;
        }

        int mid = left + (right - left) /2 ;
        if (nums[mid] == target){
            right = mid;
            sign = mid;
            helper(nums, left, right, target);
        }

        if (nums[mid] > target){
            helper(nums, left, mid-1, target);
        }else{
            helper(nums, mid+1, right, target);
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,2,3,3,3,4,8,11,17,19,47};
        int target = 1;
        int result = sol.binarySearch(nums, target);
        System.out.println(result);
    }
}
