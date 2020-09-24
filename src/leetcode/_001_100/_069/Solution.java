package leetcode._001_100._069;

import java.math.BigDecimal;

public class Solution {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        long left = 1;
        long right = x;
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

    public float sprt(int num) {

        float left = 1f;
        float right = (float)num;

        while (left + 0.01 < right) {
            float mid = left + (right - left) / 2;
            BigDecimal bigDecimal = new BigDecimal(mid);
            mid = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN).floatValue();
            if (left == mid || right == mid) {
                break;
            }
            if (mid * mid <= num) {
                left = mid;
            }else {
                right = mid;
            }
        }

        if (right * right <= num) {
            return right;
        }
        return left;
    }

}
