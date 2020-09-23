package leetcode.jianzhiOffer._003;

import java.util.concurrent.Executors;

public class Solution {

    public int findRepeatNumber(int[] nums) {
        //[2, 3, 1, 0, 2, 5, 3]
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
