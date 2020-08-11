package leetcode._647;

public class Solution {

    public int countSubstrings(String s) {
        int length = s.length();
        if (length == 0) {
            return 1;
        }
        int res= 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            res++;
        }

        for (int i = length-1; i >= 0; i--) {
            for (int j = i+1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j) && (dp[i+1][j-1] || j-i<2)) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int aba = solution.countSubstrings("aaa");
        System.out.println(aba);
    }
}
