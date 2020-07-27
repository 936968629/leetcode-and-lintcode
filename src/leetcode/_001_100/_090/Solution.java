package leetcode._001_100._090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length == 0) {
            return result;
        }
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, int[] nums, int index) {
        result.add(new ArrayList<>(item));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            item.add(nums[i]);
            dfs(result, item, nums, i+1);
            item.remove(item.size()-1);
        }
    }


}
