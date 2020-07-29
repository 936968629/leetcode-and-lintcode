package leetcode._001_100._018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, int[] nums, int target, int index) {
        if (item.size() == 4 && target == 0) {
            result.add(new ArrayList<>(item));
            return;
        }
        if (item.size() == 4) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            item.add(nums[i]);
            dfs(result, item, nums, target-nums[i], i+1);
            item.remove(item.size()-1);
        }
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;

        // 排序
        Arrays.sort(nums);

        int len =  nums.length - 3;

        for (int i = 0; i < len; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = nums.length - 1; j > i + 1; j--) {
                int L = i + 1;
                int R = j - 1;
                while (R > L) {
                    int sum = nums[i] + nums[L] + nums[R] + nums[j];
                    if (sum == target) {
                        // 由于尾指针去重不了，所以加了一层校验，这一块待优化
                        List<Integer> list = Arrays.asList(nums[i], nums[L], nums[R], nums[j]);
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                        while (R > L && nums[R - 1] == nums[R]) R--; // 去重
                        while (R > L && nums[L + 1] == nums[L]) L++; // 去重
                        L++;
                        R--;
                    }
                    if (sum > target) R--;
                    if (sum < target) L++;
                }
            }
        }
        return result;
    }

}
