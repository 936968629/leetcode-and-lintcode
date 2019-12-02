package lintcode._728;

public class Solution {

    public boolean isThreeDisctFactors(long n) {
        // write your code here
        if(n == 0 || n == 1){
            return false;
        }
        float sqrt = (float) Math.sqrt(n);

        if ((long) sqrt * sqrt != n){
            return false;
        }
        for (long i = 2; i < sqrt; i++) {
            if (sqrt % i == 0){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long n = 10;
        solution.isThreeDisctFactors(n);
    }
}
