package lintcode._101_200._159;

public class Solution {

    public int findMin(int[] nums) {
        // write your code here
        if (nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int target = nums[right];
        while ( left + 1 < right ) {
            int mid = left + (right - left) / 2;
            if ( nums[mid] == target ) {
                right = mid;
            }else if(nums[mid] < target) {
                right = mid;
            }else {
                left = mid;
            }
        }

        return  Math.min(nums[left], nums[right]);
    }

    public static void main(String[] args) {
        Class name = null;
        try {
            name = Class.forName("com.leetcode._001.Solution");
            name.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        Solution sol = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        int result = sol.findMin(nums);
        System.out.println(result);
    }

}
