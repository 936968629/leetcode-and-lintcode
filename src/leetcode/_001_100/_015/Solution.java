package leetcode._001_100._015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, int[] nums, int index) {
        if (item.size() == 3) {
            if (item.get(0) + item.get(1) + item.get(2) == 0) {
                result.add(new ArrayList<>(item));
                return;
            }
        }
        if (item.size() == 3) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if ( i > index && nums[i] == nums[i-1] ) {
                continue;
            }
            item.add(nums[i]);
            dfs(result, item, nums, i+1);
            item.remove(item.size()-1);
        }
    }



}
