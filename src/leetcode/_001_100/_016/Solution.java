package leetcode._001_100._016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    private int min = Integer.MAX_VALUE;
    private int res = 0;
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        if (length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), target);
        return res;
    }

    public void dfs(int[] numbers, int index,List<Integer> item, int target) {
        if ( item.size() == 3 ) {
            int sum = item.get(0) + item.get(1) + item.get(2);
            if ( Math.abs(sum-target) < min ) {
                min = Math.abs(sum-target);
                res = sum;
            }
            return;
        }
        for (int i = index; i < numbers.length; i++) {
            item.add(numbers[i]);
            dfs(numbers, i+1, item, target);
            item.remove(item.size()-1);
        }

    }

}
