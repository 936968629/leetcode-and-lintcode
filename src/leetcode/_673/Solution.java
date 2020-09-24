package leetcode._673;

import sun.misc.Unsafe;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {

    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int[] dp = new int[length];
        int[] count = new int[length];
        Arrays.fill(dp, 1);
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (dp[i] == max) {
                res++;
            }
        }
        return res;
    }
    class MMM implements Callable {

        @Override
        public Object call() throws Exception {
            return null;
        }
    }
//    public void test() {
//        new ThreadPoolExecutor().submit(new MMM());
//        new ThreadPoolExecutor().execute(new MMM());
//    }

    public static void main(String[] args) {
        String a = "a";


    }

}
