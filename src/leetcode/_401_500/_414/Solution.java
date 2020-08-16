package leetcode._401_500._414;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int thirdMax(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < length; i++) {
            if (!queue.contains(nums[i])) {
                if (queue.size() < 3) {
                    queue.offer(nums[i]);
                }else {
                    Integer peek = queue.peek();
                    if (nums[i] > peek) {
                        queue.poll();
                        queue.offer(nums[i]);
                    }
                }
            }
        }
        if (queue.size() < 3) {
            while (queue.size() > 1) {
                queue.poll();
            }
        }

        return queue.peek();

    }

}
