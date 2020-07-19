package leetcode._001_100._020;

import java.util.*;

public class Solution {

    public boolean isValid(String s) {
        //给定一个只包括 '('，')'，'{'，'}'，'['，']'
        int length = s.length();
        if ( length == 0 ) {
            return true;
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
