package leetcode._201_300._240;

public class Solution {

    public boolean search(int[][] matrix, int target) {
        int rows = matrix.length;
        if ( rows == 0 ) {
            return false;
        }
        int cols = matrix[0].length;
        int i = 0;
        int j = cols - 1;
        while ( i >= 0 && i < rows && j >= 0 && j < cols) {
            if ( matrix[i][j] == target ) {
                return true;
            }else if ( matrix[i][j] < target ) {
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

}
