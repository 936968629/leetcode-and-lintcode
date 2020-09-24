package leetcode._401_500._491;

import java.util.*;

public class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), 0, nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> item, Integer cur, int[] nums) {
        if (item.size() >= 2) {
            res.add(new ArrayList<>(item));
//            return;
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = cur; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);
            if (item.size() == 0 || nums[i] >= item.get(item.size()-1)) {
                item.add(nums[i]);
                dfs(res, item, i+1, nums);
                item.remove(item.size()-1);
            }
        }

    }
}
