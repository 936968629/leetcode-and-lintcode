package leetcode._001_100._020;

import java.util.*;

public class Solution {

    public boolean isValid(String s) {
        int length = s.length();
        if (length == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        List<Character> Llist = Arrays.asList('(', '[', '{');
        for (int i = 0; i < length; i++) {
            if (Llist.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            }else {
                if (stack.isEmpty()) {
                    return false;
                }else {
                    Character peek = stack.peek();
                    char item = s.charAt(i);
                    if ( (peek == '(' && item == ')') || (peek == '[' && item == ']') || (peek == '{' && item == '}') ) {
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }



}
