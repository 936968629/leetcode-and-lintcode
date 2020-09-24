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
        if (nums == null || nums.length < 4) {
            return result;
        }
        int length = nums.length;
        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < length - 3; i++) {
            int first = nums[i];
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i+1; j < length - 2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int sec = nums[j];
                int start = j+1;
                int end = length - 1;
                while (start < end) {
                    if (first + sec + nums[start] + nums[end] == target) {
                        List<Integer> item = new ArrayList<>();
                        item.add(first);
                        item.add(sec);
                        item.add(nums[start]);
                        item.add(nums[end]);
                        result.add(item);
                        start++;
                        end--;
                        while (start < end && nums[start] == nums[start-1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end+1]) {
                            end--;
                        }
                    }else if (first + sec + nums[start] + nums[end] > target) {
                        end--;
                    }else {
                        start++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int target = -1;
        Solution solution = new Solution();
        solution.fourSum2(nums, target);
    }
}
