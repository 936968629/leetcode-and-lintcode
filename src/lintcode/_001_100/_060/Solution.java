package lintcode._001_100._060;

public class Solution {

    public int searchInsert(int[] A, int target) {
        // write your code here
        int length = A.length;
        if ( length == 0 ) {
            return -1;
        }
        int left = 0;
        int right = length - 1;

        while ( left + 1 < right ) {
            int mid = left + (right - left) / 2;
            if ( A[mid] == target ) {
                right = mid;
            }else if (A[mid] < target ) {
                left = mid;
            }else{
                right = mid;
            }
        }

        if ( A[left] >= target ) {
            return left;
        }
        if ( A[right] >= target ) {
            return right;
        }
        return length;
    }

}
