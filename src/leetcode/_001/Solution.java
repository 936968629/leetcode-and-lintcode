package com.leetcode._001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                result[0] = i;
                result[1] = map.get(target-nums[i]);
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String arg[]) {

        int[] nums = {1,2,3};
        int target = 4;
        Solution sol = new Solution();
        int[] result = sol.twoSum(nums, target);
        System.out.print(Arrays.toString(result));
//        Logger logger = Logger.getGlobal();
//        logger.info("create info");
    }

}
