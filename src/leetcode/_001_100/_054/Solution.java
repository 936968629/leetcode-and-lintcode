package leetcode._001_100._054;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        if (rows == 0) {
            return result;
        }
        int cols = matrix[0].length;

        int up = 0;
        int down = rows-1;
        int left = 0;
        int right = cols-1;

        while (true) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up++;
            if (up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }

            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            down--;
            if (down < up) {
                break;
            }

            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return result;
    }

}
