package leetcode.jianzhiOffer._016;

public class Solution {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1d;
        }
        if (n > 0) {
            return helper(x, n);
        }else {
            return 1 / helper(x, -n);
        }
    }

    public double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double res = helper(x, n /2);
        if (n % 2 == 0) {
            return  res * res;
        }else {
            return x * res * res;
        }

    }

}
