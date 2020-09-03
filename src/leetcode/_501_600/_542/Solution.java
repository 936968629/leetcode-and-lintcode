package leetcode._501_600._542;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return matrix;
        }
        int cols = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    int[] item = new int[2];
                    item[0] = i;
                    item[1] = j;
                    queue.offer(item);
                }else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] coins = {{0,-1},{-1,0}, {0,1}, {1,0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < coins.length; j++) {
                    int newI = poll[0] + coins[j][0];
                    int newJ = poll[1] + coins[j][1];
                    if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && matrix[newI][newJ] == Integer.MAX_VALUE) {
                        matrix[newI][newJ] = matrix[poll[0]][poll[1]] + 1;
                        int[] item = new int[2];
                        item[0] = newI;
                        item[1] = newJ;
                        queue.offer(item);
                    }
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        // [[0,1,0,1,1],[1,1,0,0,1],[0,0,0,1,0],[1,0,1,1,1],[1,0,0,0,1]]
        int[][] nums = {
                {0,1,0,1,1},
                {1,1,0,0,1},
                {0,0,0,1,0},
                {1,0,1,1,1},
                {1,0,0,0,1}
        };
        Solution solution = new Solution();
        solution.updateMatrix(nums);
    }

}
