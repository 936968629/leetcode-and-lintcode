package lintcode._301_400._392;

import java.util.Arrays;

public class Solution {

    public long houseRobber(int[] A) {
        // write your code here
//        int length = A.length;
//        if (length == 0){
//            return 0;
//        }
//        if(length == 1){
//            return A[0];
//        }
//        if (length == 2){
//            return Math.max(A[0], A[1]);
//        }
//        long[] dp = new long[length];
//        dp[0] = A[0];
//        dp[1] = Math.max(A[0], A[1]);
//        for (int i = 2; i < length; i++) {
//            dp[i] = Math.max(dp[i-2] + A[i], dp[i-1]);
//        }
//        System.out.println(Arrays.toString(dp));
//        return dp[length-1];

        int length = A.length;
        if ( length == 0 ){
            return 0;
        }
        if ( length == 1 ) {
            return A[0];
        }
        long[] dp = new long[length+1];
        dp[0] = 0;
        dp[1] = A[0];
        for (int i = 2; i < length+1; i++) {
            dp[i] = Math.max(dp[i-2] + A[i-1], dp[i-1]);
        }
        return dp[length];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {3,8,4};
        solution.houseRobber(A);
    }

}
