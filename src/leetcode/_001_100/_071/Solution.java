package leetcode._001_100._071;

import java.util.Stack;

public class Solution {

    public String simplifyPath(String path) {
        String[] split = path.split("/");

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else if (!split[i].equals("") && !split[i].equals(".")) {
                stack.push(split[i]);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/" + stack.get(i));
        }
        return sb.toString();
    }

}
