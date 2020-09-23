package leetcode._921;

import java.util.Stack;

public class Solution {

    public int minAddToMakeValid(String S) {
        int length = S.length();
        if (length == 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char item = S.charAt(i);
            if (item == '(') {
                stack.push(item);
            }else {
                if (stack.isEmpty()) {
                    stack.push(item);
                }else {
                    char peek = stack.peek();
                    if (peek == '(') {
                        stack.pop();
                    }else {
                        stack.push(item);
                    }
                }
            }
        }

        return stack.size();
    }

    public int minAddToMakeValid2(String S) {
        int length = S.length();
        if (length == 0) {
            return 0;
        }
        int res = 0;
        int needRight = 0;
        for (int i = 0; i < length; i++) {
            char item = S.charAt(i);
            if (item == '(') {
                needRight++;
            }else {
                needRight--;
                if (needRight == -1) {
                    res++;
                    needRight = 0;
                }
            }
        }
        return res + needRight;
    }

}
