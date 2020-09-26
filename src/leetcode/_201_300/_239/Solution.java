package com.leetcode._239;

import java.util.*;

public class Solution {

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0){
            return new int[0];
        }
        Queue<Integer> queue = new PriorityQueue<>( new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] result = new int[nums.length-k+1];
        for (int i = 0; i < k-1; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 0; i < nums.length-k+1; i++) {
            queue.add(nums[i+k-1]);
            result[i] = queue.peek();
            queue.remove(nums[i]);
        }
        return result;
    }

    /**
     * 单调队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || k > length) {
            return null;
        }
        int[] res = new int[length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int start = 0;
        for (int i = 0; i < length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (i >= queue.peekFirst() + k) {
                queue.pollFirst();
            }
            if (i >= k - 1) {
                res[start] = nums[queue.peekFirst()];
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = sol.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

}
