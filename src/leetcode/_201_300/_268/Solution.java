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

    public int missingNumber3(int[] nums) {
        int length = nums.length;
        int res = length;
        for (int i = 0; i < length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

//    public int missingNumber2(int[] nums) {
//        int length = nums.length;
//        boolean zeroEx = false;
//        for (int i = 0; i < length; i++) {
//            if (nums[i] == 0) {
//                zeroEx = true;
//                nums[i] = 1;
//            }
//        }
//        if (!zeroEx) {
//            return 0;
//        }
//
//        for (int i = 0; i < length; i++) {
//            int item = Math.abs(nums[i]);
//            nums[item-1] = -Math.abs(nums[item-1]);
//        }
//
//        for (int i = 0; i < length; i++) {
//            if (nums[i] > 0) {
//                return i+1;
//            }
//        }
//        return length + 1;
//    }
}
