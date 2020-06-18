package lintcode._001_100._012;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        // do intialization if necessary
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);
        if ( minStack.isEmpty() ) {
            minStack.push(number);
        } else {
            Integer peek = minStack.peek();
            if ( number <= peek) {
                minStack.push(number);
            }
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        Integer minPeek = minStack.peek();
        Integer peek = stack.peek();
        if ( peek <= minPeek ) {
            minStack.pop();
        }
        return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minStack.peek();
    }

}
