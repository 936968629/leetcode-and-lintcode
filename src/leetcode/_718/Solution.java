package leetcode._718;

public class Solution {

    public int findLength(int[] A, int[] B) {
        int lengthA = A.length;
        int lengthB = B.length;
        if (lengthA == 0 || lengthB == 0) {
            return 0;
        }
        int[][] dp = new int[lengthA+1][lengthB+1];
        for (int i = 0; i < lengthA+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < lengthB + 1; i++) {
            dp[0][i] = 0;
        }
        int res = 0;
        for (int i = 1; i < lengthA + 1; i++) {
            for (int j = 1; j < lengthB + 1; j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(dp[i][j], res);
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return res;
    }

}
