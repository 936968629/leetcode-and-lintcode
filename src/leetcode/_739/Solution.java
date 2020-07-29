package leetcode._739;

import java.util.Stack;

public class Solution {

    public int[] dailyTemperatures(int[] T) {
        //[73, 74, 75, 71, 69, 72, 76, 73]
        //[1, 1, 4, 2, 1, 1, 0, 0]
        int length = T.length;
        if (length == 0) {
            return null;
        }
        int[] res = new int[length];

        Stack<Integer> stack = new Stack<>();
        for (int i = length-1; i >= 0 ; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek()-i;
            stack.push(i);
        }
        return res;
    }
}
