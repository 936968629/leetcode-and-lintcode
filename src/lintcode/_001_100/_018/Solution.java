package lintcode._001_100._018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if ( nums.length == 0 ) {
            result.add(new ArrayList<>());
            return result;
        }

        Arrays.sort(nums);

        dfs(result, new ArrayList<>(), 0, nums);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, int index, int[] nums) {
        result.add(new ArrayList<>(item));

        for (int i = index; i < nums.length; i++) {
            if ( i != index && nums[i] == nums[i-1] ) {
                continue;
            }
            item.add(nums[i]);
            dfs(result, item, i+1, nums);
            item.remove(item.size()-1);
        }
        Arrays.sort();
    }

}
