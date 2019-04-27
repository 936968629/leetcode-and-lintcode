package lintcode._135;

import java.util.*;

public class Solution {

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here

        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        dfs(candidates,0, cur, 0, target);
        System.out.println(res);
        return res;
    }

    public void dfs(int[] candidates,int index, List<Integer> cur, int sum, int target){

        if (target == sum){
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] <= target){
                if (i > 0 && candidates[i] == candidates[i-1]){
                    continue;
                }
                cur.add(candidates[i]);
                dfs(candidates, i, cur, sum+candidates[i], target);
                cur.remove(cur.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] can = {2,3,6,7};
        sol.combinationSum(can, 7);
    }

}
