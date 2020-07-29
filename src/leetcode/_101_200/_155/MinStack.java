package leetcode._101_200._155;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> commonStack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        commonStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (commonStack.empty()) {
            commonStack.push(x);
            minStack.push(x);
        }else {
            commonStack.push(x);
            Integer peek = minStack.peek();
            if (x <= peek) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        Integer pop = commonStack.pop();
        if (pop <= minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (commonStack.empty()) {
            return -1;
        }
        return commonStack.peek();
    }

    public int getMin() {
        if (minStack.empty()) {
            return -1;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();

    }
}
