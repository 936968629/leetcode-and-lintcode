package leetcode._501_600._503;

import java.util.Stack;

public class Solution {

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int[] newNum = new int[length * 2];
        for (int i = 0; i < length; i++) {
            newNum[i] = nums[i];
        }
        for (int i = length; i < length * 2; i++) {
            newNum[i] = nums[i % length];
        }
        //[1,2,1] 1 2 1
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= newNum[i] ) {
                stack.pop();
            }
            res[i % length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(newNum[i]);
        }
        return res;
    }

}
