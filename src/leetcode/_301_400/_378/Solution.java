package leetcode._301_400._378;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        //大顶堆
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (queue.size() < k) {
                    queue.offer(matrix[i][j]);
                }else {
                    if (matrix[i][j] < queue.peek()) {
                        queue.poll();
                        queue.offer(matrix[i][j]);
                    }
                }
            }
        }
        return queue.peek();
    }

}
