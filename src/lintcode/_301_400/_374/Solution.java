package lintcode._301_400._374;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        // write your code here

        List<Integer> res = new ArrayList<>();
        int rows = matrix.length;
        if (rows == 0){
            return res;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (colBegin <= colEnd && rowBegin <= rowEnd){
            //left -> right
            for (int j = colBegin;j <= colEnd; j++){
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            //up -> down
            for (int j = rowBegin;j<=rowEnd;j++){
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            //right -> left
            if(rowEnd >= rowBegin){
                for (int j=colEnd; j>= colBegin;j--){
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            //down -> up
            if (colEnd >= colBegin){
                for (int j=rowEnd; j>=rowBegin;j--){
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
        return res;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(sol.spiralOrder(matrix).toString());
    }

}
