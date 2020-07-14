package leetcode._101_200._120;

import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return triangle.get(0).get(0);
        }
        int length = triangle.get(size-1).size();
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = triangle.get(size-1).get(i);
        }
        for (int i = size - 2; i >= 0 ; i--) {
            int j = triangle.get(i).size();
            for (int k = 0; k < j; k++) {
                dp[k] = Math.min(triangle.get(i).get(k) + dp[k], triangle.get(i).get(k) + dp[k+1]);
            }
        }
        return dp[0];
    }

}
