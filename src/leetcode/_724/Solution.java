package leetcode._724;

public class Solution {

    public int pivotIndex(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int[] pref = new int[length+1];
        pref[0] = 0;
        for (int i = 1; i < length + 1; i++) {
            pref[i] = pref[i-1] + nums[i-1];
        }

        for (int i = 1; i < length + 1; i++) {
            int leftSum = pref[i-1] - pref[0];
            int rightSum = pref[length] - pref[i];
            if(leftSum == rightSum) {
                return i-1;
            }
        }
        return -1;
    }

}
