package lintcode._028;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here

        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;

        for (int i = 0; i < rows; i++) {
            int sign = matrix[i][col];
            if ( sign == target ) {
                return true;
            }else if (sign > target) {
                //
                return search(matrix[i], target);
            }
        }

        return false;
    }

    public boolean search(int[] num, int target) {
        int length = num.length;
        int left = 0;
        int right = length - 1;
        while ( left + 1 < right ) {
            int mid = left + (right - left) / 2;
            if ( num[mid] == target ) {
                left = mid;
            }else if ( num[mid] < target ) {
                left = mid;
            }else {
                right = mid;
            }
        }

        if ( num[left] == target || num[right] == target) {
            return true;
        }
        return false;
    }

}
