package leetcode.jianzhiOffer._0305;

import java.util.Stack;

public class SortedStack {

    private Stack<Integer> stack;

    public SortedStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        pushItem(val);
    }

    public void pushItem(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }
        Integer peek = stack.peek();
        if (peek >= val) {
            stack.push(val);
            return;
        }
        Integer pop = stack.pop();
        pushItem(val);
        stack.push(pop);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
    }

    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
