package leetcode._001_100._041;

public class Solution {

    public int firstMissingPositive(int[] nums) {
        //[3,4,-1,1]
        int length = nums.length;
        if (length == 0) {
            return 1;
        }
        int[] exist = new int[length];
        for (int i = 0; i < length; i++) {
            int item = nums[i];
            if (item > 0 && item <= length) {
                exist[item-1] = 1;
            }
        }
        for (int i = 0; i < length; i++) {
            if (exist[i] == 0) {
                return i+1;
            }
        }
        return length+1;
    }

}
