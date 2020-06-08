package lintcode._401_500._423;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    public boolean isValidParentheses(String s) {
        // write your code here
        int length = s.length();
        if ( length == 0 ) {
            return false;
        }
        List<String> left = Arrays.asList("(", "[", "{");
        List<String> right = Arrays.asList(")", "]", "}");

        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char item = chars[i];
            int size = stack.size();
            if ( size == 0 ) {
                stack.push(String.valueOf(item));
            }else {
                String peek = stack.peek();
                if ( left.contains(peek) ) {
                    if ( peek.equals("(") && String.valueOf(item).equals(")")) {
                        stack.pop();
                    }else if ( peek.equals("[") && String.valueOf(item).equals("]") ) {
                        stack.pop();
                    }else if ( peek.equals("{") && String.valueOf(item).equals("}") ) {
                        stack.pop();
                    } else {
                        stack.push(String.valueOf(item));
                    }

                }else{
                    stack.push(peek);
                }
            }
        }
        return stack.isEmpty();
    }

}
