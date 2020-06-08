package lintcode._001_100._100;

import java.util.Arrays;

public class Solution {

    public int removeDuplicates(int[] nums) {
        // write your code here
        int length = nums.length;
        if (length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }

}
