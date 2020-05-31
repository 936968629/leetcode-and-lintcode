package lintcode._001_100._016;

import java.util.*;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        Set<List<Integer>> result = new HashSet<>();
        if ( nums.length == 0 ) {
            result.add(new ArrayList<>());
            return new ArrayList<>(result);
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        helper(result, new ArrayList<>(), nums, 0, visited);
        return new ArrayList<>(result);
    }

    public void helper(Set<List<Integer>> result, List<Integer> current, int[] nums, int index, boolean[] visited) {
        if ( current.size() == nums.length ) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ( !visited[i] ) {
                visited[i] = true;
                current.add(nums[i]);
                helper(result, current, nums, i, visited);
                current.remove(current.size()-1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,1};
        sol.permuteUnique(nums);
    }

}
