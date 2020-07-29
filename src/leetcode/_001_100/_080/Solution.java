package leetcode._001_100._080;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return length;
        }
        //[0, index]
        int index = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[index-2+1] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }

}
