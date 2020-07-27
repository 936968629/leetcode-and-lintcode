package com.leetcode._239;

import java.util.*;

public class Solution {

    class MaxQueue{
        private LinkedList<Integer> queue;
        public MaxQueue() {
            queue = new LinkedList<>();
        }

        public void push(int item) {
            while (!queue.isEmpty() && queue.getLast() < item) {
                queue.removeLast();
            }
            queue.addLast(item);
        }

        public int getMax() {
            return queue.isEmpty() ? -1:queue.getFirst();
        }

        public void pop(int item) {
            if (queue.isEmpty()) {
                return ;
            }
            if (queue.getFirst() == item) {
                queue.removeFirst();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MaxQueue queue = new MaxQueue();
        int length = nums.length;
        if(nums.length * k == 0) return new int[0];
        if(k==1) return nums;
        int[] res = new int[length-k+1];
        int index = 0;
        //双端队列
        MaxQueue maxQueue = new MaxQueue();
        for (int i = 0; i < length; i++) {
            if (i < k-1) {
                maxQueue.push(nums[i]);
            }else {
                maxQueue.push(nums[i]);
                res[index++] = maxQueue.getMax();
                maxQueue.pop(nums[i-k+1]);
            }
        }
        return res;
    }

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

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = sol.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

}
