package lintcode._001_100._015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        dfs(result, nums, new ArrayList<>(), visited);
        return result;
    }

    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> item, boolean[] visited) {
        if ( item.size() == nums.length ) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ( visited[i] ) {
                continue;
            }
            item.add(nums[i]);
            visited[i] = true;
            dfs(result, nums, item, visited);
            item.remove(item.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,2,5};
        sol.permute(nums);
    }

}
