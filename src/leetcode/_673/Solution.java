package leetcode._673;

import sun.misc.Unsafe;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.atomic.LongAdder;

public class Solution {

    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int[] dp = new int[length];
        int[] count = new int[length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        new AtomicStampedReference();
//        Unsafe unsafe = sun.misc.Unsafe.getUnsafe();
        new ConcurrentHashMap<>();
        new AtomicMarkableReference<>(1, true);
        new LongAdder();
    }

}
