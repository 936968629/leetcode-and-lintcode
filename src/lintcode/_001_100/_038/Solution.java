package lintcode._001_100._038;

public class Solution {

    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int count = 0;
        int rows = matrix.length;
        if(rows == 0){
            return 0;
        }
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;

        while (row>=0 && row < rows && col >= 0 && col < cols){
            int index = matrix[row][col];
            if (target > index){
                row += 1;
            }
            if (target < index){
                col -= 1;
            }
            if (target == index){
                col -= 1;
                count += 1;
            }

        }

        return count;
    }

    public static void main(String[] args) {
//        lintcode._038.Solution sol = new lintcode._038.Solution();
//        int[][] str= {
//            {1,3,5,7},
//            {3,11,16,20},
//            {23,30,34,50}
//        };
//        int count = sol.searchMatrix(str, 3);
//        System.out.println(count);
    }

}
