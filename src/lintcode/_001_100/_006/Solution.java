package lintcode._001_100._006;

public class Solution {

    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int lenA = A.length;
        int lenB = B.length;
        int i = 0;
        int j = 0;
        int temp[] = new int[lenA + lenB];
        int k = 0;
        while ( i < lenA && j < lenB ) {
            if ( A[i] <= B[j] ) {
                temp[k] = A[i];
                i++;
            }else{
                temp[k] = B[j];
                j++;
            }
            k++;
        }
        if ( i < lenA ) {
            for (int l = i; l < lenA; l++) {
                temp[k] = A[l];
                k++;
            }
        }
        if ( j < lenB ) {
            for (int l = j; l < lenB; l++) {
                temp[k] = B[l];
                k++;
            }
        }
        return temp;
    }
}
