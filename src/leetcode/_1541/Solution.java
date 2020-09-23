package leetcode._1541;

import java.util.Stack;

public class Solution {

    public int minInsertions(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int res = 0;
        int needRight = 0;

        for (int i = 0; i < length; i++) {
            char item = s.charAt(i);
            if (item == '(') {
                needRight += 2;
                if (needRight % 2 == 1) {
                    res++;
                    needRight ++;
                }
            }else {
                needRight--;
                if (needRight == -1) {
                    res++;
                    needRight = 1;
                }
            }
        }
        return res + needRight;
    }

    public int minInsertions2(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char item = s.charAt(i);
            if (item == '(') {
                stack.push(item);
            }else {
                if (i+1 == length) {
                    if (stack.isEmpty()) {
                        res += 2;
                    }else {
                        stack.pop();
                        res += 1;
                    }
                }else {
                    if (s.charAt(i+1) == ')') {
                        if (stack.isEmpty()) {
                            res += 1;
                            i++;
                        }else {
                            stack.pop();
                            i++;
                        }
                    }else {
                        if (stack.isEmpty()) {
                            res += 2;
                        }else {
                            res += 1;
                            stack.pop();
                        }
                    }
                }


            }
        }


        return res + stack.size() * 2;
    }

}
