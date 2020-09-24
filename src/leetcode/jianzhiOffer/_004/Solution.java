package leetcode.jianzhiOffer._004;

public class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        int row = 0;
        int col = cols-1;
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (matrix[row][col] == target) {
                return true;
            }else if (matrix[row][col] > target) {
                col--;
            }else {
                row++;
            }
        }
        return false;
    }

}
