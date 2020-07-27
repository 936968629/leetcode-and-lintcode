package leetcode._001_100._039;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = candidates.length;
        if (length == 0) {
            return result;
        }
        dfs(result, new ArrayList<>(), target, 0, candidates);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, int target, int index, int[] candidates) {
        if (target == 0) {
            result.add(new ArrayList<>(item));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            item.add(candidates[i]);
            dfs(result, item, target-candidates[i], i, candidates);
            item.remove(item.size()-1);
        }
    }

}
