package com.leetcode._239;

import java.util.*;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
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

        for (int i =0; i<nums.length-k+1;i++){
            if (i == 0) {
                for (int j = 0;j < k;j++){
                    queue.add(nums[j]);
                }
            } else {
                queue.add(nums[i+k-1]);
            }
            result[i] = queue.peek();
            queue.remove(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = sol.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

}
