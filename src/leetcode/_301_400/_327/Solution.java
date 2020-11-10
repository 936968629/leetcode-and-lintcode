package leetcode._301_400._327;

import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i+1] = sum;
        }
        Set<Long> allNumbers = new TreeSet<Long>();


        return -1;
    }

}
