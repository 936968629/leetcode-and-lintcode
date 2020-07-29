package leetcode._101_200._137;

import java.util.*;

public class Solution {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }else {
                Integer integer = map.get(nums[i]);
                integer++;
                map.put(nums[i], integer);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue() == 1) {
                return next.getKey();
            }
        }
        return 0;
    }

}
