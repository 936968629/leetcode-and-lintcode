package lintcode._381;

import java.util.Arrays;

public class Solution {

    public int[][] generateMatrix(int n) {
        // write your code here
        int[][] result = new int[n][n];

        int rowBegin = 0;
        int colBegin = 0;
        int colEnd = n-1;
        int rowEnd = n-1;
        int current = 1;
        while (rowBegin < n && colBegin < n){
            //right -> left
            for (int i = colBegin; i<= colEnd;i++ ){
                result[rowBegin][i] = current;
                current++;
            }
            rowBegin++;
            //up -> down
            for (int i = rowBegin;i<=rowEnd;i++){
                result[i][colEnd] = current;
                current++;
            }
            colEnd--;
            //right -> left
            for (int i=colEnd;i>= colBegin;i--){
                result[rowEnd][i] = current;
                current++;
            }
            rowEnd--;
            //right -> left
            for (int i=rowEnd;i>=rowBegin;i--){
                result[i][colBegin] = current;
                current++;
            }
            colBegin++;

        }

        return result;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4;
        int[][] res = sol.generateMatrix(n);
        System.out.println(Arrays.deepToString(res));

    }

}
