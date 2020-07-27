package leetcode._001_100._040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = candidates.length;
        if (length == 0) {
            return result;
        }
        Arrays.sort(candidates);
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
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            item.add(candidates[i]);
            dfs(result, item, target-candidates[i], i+1, candidates);
            item.remove(item.size()-1);
        }
    }
}
