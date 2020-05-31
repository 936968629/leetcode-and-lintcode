package lintcode._401_500._428;

public class Solution {

    public double myPow(double x, int n) {
        // write your code here
        if ( n == 0 ) {
            return 1;
        }
        if ( n > 0 ) {
            return pow(x, n);
        }else{
            return 1.0 / pow(x,n);
        }
    }

    public double pow(double x, int n) {
        if ( n == 0 ) {
            return 1;
        }

        double anx = pow(x, n /2);
        if ( n % 2 == 0 ) {
            return anx * anx;
        }else {
            return anx * anx * x;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.myPow(9.88023, -3);
    }

}
