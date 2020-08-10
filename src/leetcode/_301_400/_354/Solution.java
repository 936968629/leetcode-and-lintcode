package leetcode._301_400._354;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int maxEnvelopes(int[][] envelopes) {
        int rows = envelopes.length;
        if (rows == 0) {
            return 0;
        }
        int cols = envelopes[0].length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }else {
                    return o2[1] - o1[1];
                }
            }
        });

        int res = 1;
        int[] dp = new int[rows];
        Arrays.fill(dp, 1);
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{46,89},{50,53},{52,68},{72,45},{77,81}};
        solution.maxEnvelopes(nums);
    }

}
