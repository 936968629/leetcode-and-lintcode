package leetcode._001_100._026;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        int i = 0;
        int j = 1;
        while (j < length) {
            if (nums[j] == nums[i]) {
                j++;
            }else {
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return i+1;
    }

}
