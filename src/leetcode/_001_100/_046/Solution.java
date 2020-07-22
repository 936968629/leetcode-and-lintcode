package leetcode._001_100._046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length == 0) {
            return result;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        dfs(result, new ArrayList<>(), nums, 0, visited);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, int[] nums, int index, boolean[] visited) {
        if (item.size() == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                item.add(nums[i]);
                visited[i] = true;
                dfs(result, item, nums, i+1, visited);
                item.remove(item.size()-1);
                visited[i] = false;
            }
        }
    }

}
