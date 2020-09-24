package leetcode.jianzhiOffer._049;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }

        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();

        queue.offer(1L);

        int[] coins = {2,3,5};
        for (int i = 1; i < n; i++) {
            Long item = queue.poll();
            for(int coin : coins) {
                Long newItem = item * coin;
                if (!set.contains(newItem)) {
                    set.add(newItem);
                    queue.offer(newItem);
                }
            }
        }

        return queue.peek().intValue();
    }

}
