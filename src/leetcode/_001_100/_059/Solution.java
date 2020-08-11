package leetcode._001_100._059;

public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int up = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;

        int index = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                matrix[up][i] = index;
                index++;
            }
            up++;
            if (up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                matrix[i][right] = index;
                index++;
            }
            right--;
            if (right < left) {
                break;
            }

            for (int i = right; i >= left; i--) {
                matrix[down][i] = index;
                index++;
            }
            down--;
            if (down < up) {
                break;
            }

            for (int i = down; i >= up; i--) {
                matrix[i][left] = index;
                index++;
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return matrix;
    }

}
