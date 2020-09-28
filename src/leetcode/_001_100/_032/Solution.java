package leetcode._001_100._032;

import java.util.Stack;

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

    public int longestValidParentheses2(String s) {
        //用栈模拟一遍，将所有无法匹配的括号的位置全部置1
        //例如: "()(()"的mark为[0, 0, 1, 0, 0]
        //再例如: ")()((())"的mark为[1, 0, 0, 1, 0, 0, 0, 0]
        //经过这样的处理后, 此题就变成了寻找最长的连续的0的长度
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int[] nums = new int[length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (s.charAt(i)== '(') {
                stack.push(i);
            }else {
                if (stack.isEmpty()) {
                    nums[i] = 1;
                }else {
                    stack.pop();
                }

            }
        }

        while (!stack.isEmpty()) {
            nums[stack.peek()] = 1;
            stack.pop();
        }
        int res = 0;
        int len = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                len++;
            }else {
                len = 0;
            }
            len++;
            res = Math.max(res, len);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestValidParentheses("()(())");
    }
}
