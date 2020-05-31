package lintcode._544;

import java.util.*;

public class Solution {

    public int[] topk(int[] nums, int k) {
        // write your code here
        if ( nums == null || nums.length == 0 ) {
            return nums;
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            int size = queue.size();
            if ( size < k ) {
                queue.offer(nums[i]);
            } else {
                Integer peek = queue.peek();
                if ( nums[i] > peek ) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }

        int[] result = new int[k];
        for (int i = k-1; i >= 0; i--) {
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,10,1000,-99,4,100};
        solution.topk(nums, 4);
    }
}
