package leetcode._001_100._078;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length == 0) {
            return result;
        }
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, int[] nums, int index) {
        result.add(new ArrayList<>(item));
        for (int i = index; i < nums.length; i++) {
            item.add(nums[i]);
            dfs(result, item, nums, i+1);
            item.remove(item.size()-1);
        }
    }

}
