package lintcode._001_100._004;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int nthUglyNumber(int n) {
        // write your code here
        Queue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        heap.offer(1L);
        int[] ans = {2,3,5};
        if ( n == 1 ) {
            return 1;
        }
        Long result = 1L;
        for (int i = 0; i < n; i++) {
            result = heap.poll();
            for (int j = 0; j < ans.length; j++) {
                long newItem = result * ans[j];
                if ( set.contains(newItem) ) {
                    continue;
                } else {
                    heap.offer(newItem);
                    set.add(newItem);
                }
            }
        }

        return result.intValue();
    }

}
