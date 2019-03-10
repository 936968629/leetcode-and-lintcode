package lintcode._160;

public class Solution {

    public int findMin(int[] nums) {
        // write your code here
        int length = nums.length;
        if (length == 0){
            return -1;
        }

        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else if (nums[mid] < nums[left]){
                right = mid;
            }else{
                right--;
            }

        }
        return nums[left];
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,0,1,1,1};
        int result = sol.findMin(nums);
        System.out.println(result);
    }

}
