package leetcode._201_300._225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue1;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i = 0; i < queue1.size() - 1; i++) {
            queue1.offer(queue1.poll());
        }
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        for (int i = 0; i < queue1.size() - 1; i++) {
            queue1.offer(queue1.poll());
        }
        int top  = queue1.peek();
        queue1.offer(queue1.poll());
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

}
