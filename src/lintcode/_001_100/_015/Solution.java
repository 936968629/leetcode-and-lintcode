package lintcode._001_100._015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        if (nums.length == 0){
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        dfs(nums, 0, cur, visited);
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> cur, boolean[] visited){
        if (index == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ( !visited[i] ){
                visited[i] = true;
                cur.add(nums[i]);
                dfs(nums, index+1, cur, visited);
                cur.remove(cur.size()-1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if ( nums.length == 0 ) {
            result.add(new ArrayList());
            return result;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        helper(result, new ArrayList<>(), nums, 0, visited);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> current, int[] nums, int index, boolean[] visited) {
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
        int[] nums = {1,2,5};
        sol.permute(nums);
    }

}
