package lintcode._001_100._064;

import java.util.Arrays;

public class Solution {

    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int all = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while ( i >= 0 && j >= 0 ) {
            if ( A[i] > B[j] ) {
                A[all] = A[i];
                all--;
                i--;
            }else {
                A[all] = B[j];
                all--;
                j--;
            }
        }

        while ( i >= 0 ) {
            A[all] = A[i];
            all--;
            i--;
        }

        while ( j >= 0 ) {
            A[all] = B[j];
            all--;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

}
