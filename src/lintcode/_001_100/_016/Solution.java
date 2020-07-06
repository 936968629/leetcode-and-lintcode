package lintcode._001_100._016;

import java.util.*;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
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
            if ( i > 0 && nums[i] == nums[i-1] && visited[i-1]) {
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
        int[] nums = {1,1};
        sol.permuteUnique(nums);
    }

}
