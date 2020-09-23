package leetcode._001_100._097;

import java.util.Collections;

public class Solution {


    //0-1
    public int packagea(int[] wights, int[] values, int wight) {
        //dp[i][j]表示 装前i个 重量为j的最大价值
        //dp[i][j] 不装第i个 dp[i-1][j]  装dp[i-1][j-height[k]]

        int[][] dp = new int[wights.length+1][wight+1];
        for (int i = 0; i < wights.length + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < wight + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < wights.length + 1; i++) {
            for (int j = 1; j < wight + 1; j++) {
                if (j >= wights[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wights[i-1]] + values[i-1]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[wights.length][wight];
    }

    //完全背包
    public int packagea2(int[] wights, int[] values, int wight) {
        //dp[i][j]表示 装前i个 重量为j的最大价值
        //dp[i][j] 不装第i个 dp[i-1][j]  装dp[i-1][j-height[k]]
        int[][] dp = new int[wights.length+1][wight+1];
        for (int i = 0; i < wights.length + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < wight + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < wights.length + 1; i++) {
            for (int j = 1; j < wight + 1; j++) {
                if (j >= wights[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-wights[i-1]] + values[i-1]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[wights.length][wight];
    }


    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len1 == len2 && len1 == len3 && len1 == 0) {
            return true;
        }
        if (len1 + len2 != len3) {
            return false;
        }
        // s1前i个字符  s2前j个字符 能否构建成 s3 i + j个字符
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for (int i = 1; i < len1 + 1; i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int i = 1; i < len2 + 1; i++) {
            dp[0][i] = dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                int p = i + j - 1;
                boolean re1 = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(p);
                boolean re2 = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(p);
                dp[i][j] = re1 || re2;
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] wights = {2, 1, 3};
        int[] values = {4, 2, 3};
//        int packagea = solution.packagea(wights, values, 4);
        int packagea2 = solution.packagea2(wights, values, 10);
        System.out.println(packagea2);

        solution.isInterleave("db", "b", "cbb");
    }
}
