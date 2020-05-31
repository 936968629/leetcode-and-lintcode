package lintcode._101_200._161;

import java.util.Arrays;

public class Solution {

    public void rotate(int[][] matrix) {
        // write your code here
        if (matrix.length == 0){
            return ;
        }
        //[x][y] --> [y][n - 1 - x]
        int n = matrix.length;
        for (int i = 0; i < (n+1) / 2 ; i++) {
            for (int j = 0; j < n / 2 ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        sol.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
