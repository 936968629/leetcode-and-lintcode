package lintcode._301_400._397;

public class Solution {

    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        int length = A.length;
        int res = Integer.MIN_VALUE;
        if ( length == 0 ) {
            return 0;
        }
        if ( length == 1 ) {
            return 1;
        }
        int len = 1;
        for (int i = 1; i < length; i++) {
            if ( A[i] > A[i-1] ) {
                len++;
            } else {
                len = 1;
            }
            res = Math.max(res, len);
        }
        len = 1;
        for (int i = length - 1; i > 0 ; i--) {
            if ( A[i] < A[i-1] ) {
                len++;
            } else {
                len = 1;
            }
            res = Math.max(res, len);
        }
        return res;
    }

}
