package lintcode._191;

public class Solution {

    public int maxProduct(int[] nums) {
        // write your code here
        int len = nums.length;
        if (len == 0){
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            int temp = min;
            min = Math.min(nums[i], Math.min(min*nums[i], max*nums[i]));
            max = Math.max(nums[i], Math.max(temp*nums[i], max*nums[i]));

            res = Math.max(res, max);
        }

        return res;

    }

    public static void main(String[] args) {
//        [-1,2,4,1,-2]
    }

}
