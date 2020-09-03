package leetcode._1162;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int maxDistance(int[][] grid) {
        // 0海洋  1陆地
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int[] item = new int[2];
                    item[0] = i;
                    item[1] = j;
                    queue.offer(item);
                }else {
                    grid[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        int[][] coins = {{0,1},{1,0}, {0,-1}, {-1,0}};

        int res = 0;
        boolean isSign = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int oldI = poll[0];
                int oldJ = poll[1];
                for (int j = 0; j < coins.length; j++) {
                    int newI = oldI + coins[j][0];
                    int newJ = oldJ + coins[j][1];
                    if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && grid[newI][newJ] == Integer.MIN_VALUE) {
                        grid[newI][newJ] = grid[oldI][oldJ] + 1;
                        res = Math.max(res, grid[newI][newJ]);
                        isSign = true;
                        int[] item = new int[2];
                        item[0] = newI;
                        item[1] = newJ;
                        queue.offer(item);
                    }
                }
            }
        }
        if (!isSign) {
            return -1;
        }
        return res - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{1,0,0}, {0,0,0}, {0,0,0}};
        solution.maxDistance(nums);
    }

}
