package lintcode._101_200._135;

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

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();

        Set<List<Integer>> rest = new HashSet<>();
        Arrays.sort(candidates);
        if ( candidates.length == 0 ) {
            return result;
        }
        helper( candidates, target, 0, rest, new ArrayList<>(),0 );
        return new ArrayList<>(rest);
    }

    public void helper(int[] candidates, int target,int cureent,Set<List<Integer>> result, List<Integer> item, int index) {
        if ( cureent == target ) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if ( target - candidates[i] >= cureent ) {
                item.add(candidates[i]);
                helper(candidates, target, cureent + candidates[i], result, item, i);
                item.remove(item.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] can = {2,3,6,7};
        sol.combinationSum(can, 7);
    }

}
