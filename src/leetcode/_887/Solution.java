package leetcode._887;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

public class Solution {

    public int superEggDrop(int K, int N) {
        //dp（k,D）表示K个鸡蛋D次最高楼层
        //dp(k,d) = dp(k-1,d-1) + 1 + dp(k, d-1)
        if (K == 1) {
            return N;
        }
        int[][] dp = new int[N+1][K+1];
        for (int i = 0; i < N+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < K + 1; i++) {
            dp[0][i] = 0;
        }
        int res = 0;
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < K+1; j++) {
                dp[i][j] = dp[i-1][j-1] + 1 + dp[i-1][j];
            }
            if (dp[i][K] >= N) {
                res = i;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.superEggDrop(2, 6);
    }

}
