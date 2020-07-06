package lintcode._101_200._142;

public class Solution {

    public boolean checkPowerOf2(int n) {
        // write your code here
        if ( n <= 0 ) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

}
