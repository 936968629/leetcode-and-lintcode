package lintcode._101_200._160;

public class Solution {

    public int findMin(int[] nums) {
        // write your code here
        if (nums.length == 0){
            return -1;
        }

        int start = 0, end = nums.length-1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[end]) {
                // if mid equals to end, that means it's fine to remove end
                // the smallest element won't be removed
                end--;
            } else if (nums[mid] < nums[end]) {
                end = mid;
                // of course you can merge == & <
            } else {
                start = mid+1;
                // or start = mid + 1
            }
        }

        return Math.min(nums[start], nums[end]);
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,0,1,1,1};
        int result = sol.findMin(nums);
        System.out.println(result);
    }

}
