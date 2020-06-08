package lintcode._001_100._042;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int maxTwoSubArrays(List<Integer> nums) {
        int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.size();i++) {
            if (currentSum <= 0) {
                currentSum = nums.get(i);
            } else {
                currentSum += nums.get(i);
            }
            left[i] = maxSum = Math.max(currentSum, maxSum);
        }
        currentSum = 0;
        maxSum = Integer.MIN_VALUE;
        for (int i = nums.size() - 1; i >= 0;i--) {
            if (currentSum <= 0) {
                currentSum = nums.get(i);
            } else {
                currentSum += nums.get(i);
            }
            right[i] = maxSum = Math.max(currentSum, maxSum);
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> nums = Arrays.asList(1, 3, -1, 2, -1, -5, 1);
        solution.maxTwoSubArrays(nums);
        List<Integer> a = new ArrayList<>();
        a.add(1);
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.add(5);
    }
}
