package lintcode._028;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here

        int rows = matrix.length;
        if (rows == 0)
            return false;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;

        while (0 <= row && row < rows && 0 <= col && col < cols ) {
            int sign = matrix[row][col];
            if (target == sign)
                return true;
            if (target > sign){
                row += 1;
            }else{
                col -= 1;
            }
        }
        return false;
    }

}
