package leetcode._001_100._032;

public class Solution {

    public int longestValidParentheses(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = 0;
        int res = 0;
        for (int i = 2; i < length+1; i++) {
            if (s.charAt(i-1) == ')') {
                if (s.charAt(i-2) == '(') {
                    dp[i] = dp[i-2] + 2;
                }else if (i - dp[i - 1] - 2 >= 0 && s.charAt(i - dp[i - 1] - 2) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0);
                }
                res = Math.max(res, dp[i]);
            } else {
                dp[i] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestValidParentheses("()(())");
    }
}
