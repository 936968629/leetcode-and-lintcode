package lintcode._101_200._141;

public class Solution {

    public int sqrt(int x) {
        // write your code here

        long left = 0;
        long right = x;
        if ( x < 0 ) {
            return -1;
        }

        while ( left + 1 < right) {
            long mid = left + (right - left) / 2;
            if ( mid * mid == x ) {
                right = mid;
            }else if ( mid * mid < x ) {
                left = mid;
            }else {
                right = mid;
            }
        }

        if ( right * right <= x ) {
            return (int)right;
        }
        if ( left * left <= x ) {
            return (int)left;
        }
        return 0;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sqrt(999999999);
    }
}
