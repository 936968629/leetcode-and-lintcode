package leetcode.jianzhiOffer._031;

import java.util.Stack;

public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int item : pushed) {
            stack.push(item);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }


    public void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Integer pop = stack.pop();
        reverseStack(stack);
        // 值push到栈底
        pushStackBottom(stack, pop);
    }

    public void pushStackBottom(Stack<Integer> stack, int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }
        int pop = stack.pop();
        pushStackBottom(stack, val);
        stack.push(pop);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(1);
        stack.push(3);
        solution.reverseStack(stack);
        System.out.println(stack.toString());
    }

}
