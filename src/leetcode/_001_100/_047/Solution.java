package leetcode._001_100._047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length == 0) {
            return result;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, 0, visited);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, int[] nums, int index, boolean[] visited) {
        if (item.size() == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && visited[i-1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            item.add(nums[i]);
            visited[i] = true;
            dfs(result, item, nums, 0, visited);
            visited[i] = false;
            item.remove(item.size()-1);
        }
    }

}
