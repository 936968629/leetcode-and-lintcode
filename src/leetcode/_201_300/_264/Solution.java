package leetcode._201_300._264;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int nthUglyNumber(int n) {

        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();

        queue.offer(1L);
        int[] coins = {2,3,5};
        for (int i = 1; i < n; i++) {
            long itemLong = queue.poll();
//            int item = (int)itemLong;
            for (Integer coin : coins) {
                long newItem = itemLong * coin;
                if (!set.contains(newItem)) {
                    set.add(newItem);
                    queue.offer(newItem);
                }
            }
        }
        return queue.peek().intValue();
    }

}
