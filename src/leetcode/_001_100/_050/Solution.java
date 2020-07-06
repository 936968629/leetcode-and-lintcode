package leetcode._001_100._050;

public class Solution {

    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }else if (n > 0){
            return pow(x, n);
        }else {
            return 1 / pow(x, n);
        }
    }

    public double pow(double x, int n) {
        if (n==0){
            return 1;
        }
        if ( n == 1 ) {
            return x;
        }
        double anx = pow(x, n /2);
        if ( n % 2 == 0 ) {
            return anx * anx;
        }else {
            return anx * anx * x;
        }
    }
}
