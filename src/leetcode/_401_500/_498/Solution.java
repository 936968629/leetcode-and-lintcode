package leetcode._401_500._498;

public class Solution {

    public int[] findDiagonalOrder(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            int[] res = new int[0];
            return res;
        }
        int cols = matrix[0].length;
        int r = 0;
        int c = 0;
        int[] res = new int[rows * cols];

        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            if ((r + c) % 2 == 0) {
                //向上遍历
                if (c == cols - 1) {
                    r++;
                }else if (r == 0) {
                    c++;
                }else {
                    r--;
                    c++;
                }
            }else {
                //向下遍历
                if (r == rows - 1) {
                    c++;
                }else if (c == 0) {
                    r++;
                }else {
                    r++;
                    c--;
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        solution.findDiagonalOrder(nums);
    }

}
