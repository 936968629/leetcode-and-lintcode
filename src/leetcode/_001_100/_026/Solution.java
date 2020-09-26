package leetcode._001_100._026;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 1 || length == 0) {
            return length;
        }
        int start = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[start]) {
                continue;
            }
            start++;
            nums[start] = nums[i];
        }
        return start + 1;
    }

}
