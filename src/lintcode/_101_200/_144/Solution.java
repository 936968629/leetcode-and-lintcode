package lintcode._101_200._144;

import java.util.Arrays;

public class Solution {

    public void rerange(int[] A) {
        // write your code here
        int length = A.length;
        if ( length == 0 ) {
            return;
        }
        int i = 0;
        int j = length - 1;
        while ( i < j ) {
            if ( A[i] < 0 ) {
                i++;
                continue;
            }
            if ( A[j] > 0 ) {
                j--;
                continue;
            }
            swap(i, j, A);
            i++;
            j--;
        }
        int numOfNegative = 0;
        int numOfPositive = 0;
        for (int num : A) {
            if (num < 0) {
                numOfNegative++;
            }
            if (num > 0) {
                numOfPositive++;
            }
        }
        if ( numOfNegative > numOfPositive ) {
            i = 1;
            j = length - 1;
        }else if ( numOfNegative < numOfPositive ) {
            i = 0;
            j = length - 2;
        }else {
            i = 0;
            j = length -1;
        }
        while ( i < j ) {
            swap(i, j , A);
            i += 2;
            j -= 2;
        }
    }

    public void swap(int i, int j, int[] A) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {2, -2 ,3, 9, -1};
        solution.rerange(A);
        System.out.println(Arrays.toString(A));
    }
}
