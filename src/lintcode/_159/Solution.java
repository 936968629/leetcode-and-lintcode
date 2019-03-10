package lintcode._159;

public class Solution {

    public int findMin(int[] nums) {
        // write your code here
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int left = 0;
        int right = length-1;

        while (left < right){
            int middle = (left + right) >> 1;
            if (nums[middle] > nums[right] ){
                left = middle + 1;
            }
            else{
                right = middle;
            }


        }

        return nums[left];

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
