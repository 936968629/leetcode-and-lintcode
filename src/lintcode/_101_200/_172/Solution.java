package lintcode._101_200._172;

public class Solution {

    public int removeElement(int[] A, int elem) {
        // write your code here
        int length = A.length;

        if ( A.length == 0 ) {
            return 0;
        }

        int i = 0;
        int j = length - 1;

        while ( i <= j ) {
            while ( i <= j && A[j] == elem ) {
                j--;
            }
            while ( i <= j && A[i] != elem ) {
                i++;
            }
            if ( i<j ) {
                swap(A, i, j);
            }
        }
        int res = 0;
        for (int k = 0; k < length; k++) {
            if ( A[k] != elem ) {
                res++;
            }
        }
        return res;
    }

    public void swap(int[] A, int i , int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {0,4,4,0,0,2,4,4};
        solution.removeElement(A, 4);
    }
}
