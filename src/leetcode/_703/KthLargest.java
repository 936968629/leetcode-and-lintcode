package leetcode._703;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {

    private Queue<Integer> queue;

    private int k ;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>(k);
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
            }else {
                Integer poll = queue.peek();
                if (nums[i] > poll) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
    }

    public int add(int val) {
        int size = queue.size();
        if (size < k) {
            queue.offer(val);
            return queue.peek();
        }
        Integer poll = queue.peek();
        if (val > poll) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}