package leetcode._001_100._069;

public class Solution {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        long left = 1;
        long right = x / 2;
        while ( left + 1 < right ) {
            long middle = left + (right - left) / 2;
            if (middle * middle == x) {
                return (int)middle;
            }else if (middle * middle < x) {
                left = middle;
            }else {
                right = middle;
            }
        }
        if ( right * right <= x ) {
            return (int)right;
        }
        if (left * left < x) {
            return (int) left;
        }
        return 0;
    }

}
