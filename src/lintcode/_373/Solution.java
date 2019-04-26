package lintcode._373;

import java.util.Arrays;

public class Solution {

    public int[] partitionArray(int[] nums){

        int length = nums.length;
        if(length == 0) {
            return nums;
        }
        int left = 0;
        int right = length - 1;

        while (left < right){
            if (nums[left] % 2 == 0){
                //是偶数
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }else{
                left++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] num = {2147483647,2147483645,2147483646,2147483647};
        int[] result = sol.partitionArray(num);
        System.out.println(Arrays.toString(result));
    }

}
