package leetcode._101_200._128;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        int cur = 1;
        for (int num : nums) {
            if (set.contains(num-1)) {
                continue;
            }
            int newNum = num + 1;
            while (set.contains(newNum)) {
                cur++;
                newNum = newNum + 1;
            }
            res = Math.max(cur, res);
            cur = 1;

        }
        return res;
    }

}
