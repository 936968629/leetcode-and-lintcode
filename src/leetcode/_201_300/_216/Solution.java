package leetcode._201_300._216;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candicate = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, new ArrayList<>(), n, k, 0, candicate);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, int target, int k, int index, int[] candicate) {
        if (target == 0 && k == 0) {
            result.add(new ArrayList<>(item));
            return;
        }
        if (target <= 0) {
            return;
        }
        if (k == 0) {
            return;
        }
        for (int i = index; i < candicate.length; i++) {
            item.add(candicate[i]);
            dfs(result, item, target - candicate[i], k-1, i+1, candicate);
            item.remove(item.size()-1);
        }
    }

}
