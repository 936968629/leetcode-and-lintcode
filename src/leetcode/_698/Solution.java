package leetcode._698;

import java.util.Arrays;

public class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (maxNum < nums[i]) {
                maxNum = nums[i];
            }
        }
        if (sum % k != 0 || maxNum > sum/k) {
            return false;
        }
        boolean[] used = new boolean[nums.length];

        return dfs(nums, k, used, sum / k, 0, 0);
    }

    public boolean dfs(int[] nums, int k, boolean[] used, int target, int cur, int index) {
        if (k == 0) {
            return true;
        }
        if (cur == target) {
            return dfs(nums, k-1, used, target, 0, 0);
        }

        for (int i = index; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (dfs(nums, k, used, target, cur + nums[i], i+1) ) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}
