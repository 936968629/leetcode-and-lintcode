package leetcode._901_1000._973;

import java.util.PriorityQueue;

public class Solution {

    public int[][] kClosest(int[][] points, int K) {
        if (K == 0) {
            return new int[1][2];
        }

        int rows = points.length;
        //降序
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> {
            return o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] - o1[1] * o1[1];
        }));

        for (int i = 0; i < rows; i++) {
            if (queue.size() < K) {
                queue.offer(points[i]);
            }else if(queue.comparator().compare(points[i], queue.peek()) > 0){
                queue.poll();
                queue.offer(points[i]);
            }
        }

        int[][] res = new int[queue.size()][2];
        int idx = 0;
        for (int[] item : queue) {
            res[idx] = item;
            idx++;
        }
        return res;
    }

}
