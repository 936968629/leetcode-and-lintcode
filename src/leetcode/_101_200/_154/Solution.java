package leetcode._101_200._154;

public class Solution {

    public int findMin(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        int left = 0;
        int right = length - 1;
        while (left + 1 < right){

            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]){
                right = mid;
            }else if(nums[mid] > nums[right]){
                left = mid;
            }else{
                right--;
            }

        }
        return Math.min(nums[left], nums[right]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,5};
        solution.findMin(nums);
    }

}
