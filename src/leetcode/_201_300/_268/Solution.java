package leetcode._201_300._268;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return length;
    }

}
