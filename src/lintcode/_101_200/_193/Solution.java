package lintcode._101_200._193;

import java.util.Stack;

public class Solution {

    public int longestValidParentheses(String s) {
        // write your code here
        if ( s == null || s.length() == 0 ) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if ( s.charAt(i) == '(' ) {
                stack.push(i);
            } else {
                if ( stack.empty() || s.charAt(stack.peek()) == ')'  ) {
                    stack.push(i);
                } else {
                    stack.pop();
                    res = Math.max(res, i - (stack.isEmpty() ? -1 : stack.peek()));
                }
            }

        }

        return res;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = ")()())";
        int i = solution.longestValidParentheses(s);
        System.out.println(i);
    }
}
