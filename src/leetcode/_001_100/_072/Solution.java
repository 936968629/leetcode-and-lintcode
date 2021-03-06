package leetcode._001_100._072;

public class Solution {

    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        //代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 0; i < length1 + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < length2 + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                }
            }
        }

        return dp[length1][length2];
    }

}
