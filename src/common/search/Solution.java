package common.search;

public class Solution {

    public int twoSplitSearch(int[] nums, int target){

        int left = 0;
        int right = nums.length;
        int sign = -1;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target){
                sign = mid;
                right = mid;
            }
            if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        System.out.println(sign);
        return sign == -1 ? -1 : sign;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,5,8,10,19,88,90};
        sol.twoSplitSearch(nums, 1);
    }
}
