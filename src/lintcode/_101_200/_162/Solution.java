package lintcode._101_200._162;

import java.util.*;

public class Solution {

    class Command{
        int key;
        int value;
        public Command(int key , int value){
            this.key = key;
            this.value = value;
        }
    }

    public void setZeroes(int[][] matrix) {
        // write your code here
        int rows = matrix.length;
        if (rows == 0){
            return;
        }
        int cols = matrix[0].length;
        List<Command> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0){
                    list.add(new Command(i, j));
                }
            }
        }

        for(Iterator iterator = list.iterator();iterator.hasNext();){
            Command next = (Command) iterator.next();
            int key = next.key;
            int value = next.value;

            for (int i = 0; i < cols; i++) {
                matrix[key][i] = 0;
            }
            for (int i = 0; i < rows; i++) {
                matrix[i][value] = 0;
            }

        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] mas = {
                {3,5,5,6,9,1,4,5,0,5},
                {2,7,9,5,9,5,4,9,6,8},
                {6,0,7,8,1,0,1,6,8,1},
                {7,2,6,5,8,5,6,5,0,6},
                {2,3,3,1,0,4,6,5,3,5},
                {5,9,7,3,8,8,5,1,4,3},
                {2,4,7,9,9,8,4,7,3,7},
                {3,5,2,8,8,2,2,4,9,8}
        };
        sol.setZeroes(mas);
    }

}
