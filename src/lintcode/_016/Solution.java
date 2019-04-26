package lintcode._016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public HashSet<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur, visited);
        return new ArrayList<>(res);
    }

    public void dfs(int[] nums, int index, List<Integer> cur, boolean[] visited){

        if (index == nums.length){
            List<Integer> temp = new ArrayList<>();
            if (!res.contains(temp)){
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if ( !visited[i]){
                visited[i] = true;
                cur.add(nums[i]);
                dfs(nums, index+1, cur, visited);
                cur.remove(cur.size()-1);
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
