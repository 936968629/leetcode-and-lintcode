package lintcode._012;

import java.util.Stack;

public class MinStack {

    public Stack<Integer> stack = new Stack<>();
    public Stack<Integer> stackMin = new Stack<>();

    public MinStack() {
        // do intialization if necessary
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);
        if(stackMin.size() == 0){
            stackMin.push(number);
        }else{
            Integer popItem = stackMin.peek();
            if(number <= popItem){
                stackMin.push(number);
            }
        }

    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if(stack.size() == 0){
            return -1;
        }
        Integer item = stack.pop();
        Integer minItem = stackMin.peek();
        if(item.equals(minItem)){
            stackMin.pop();
        }
        return item;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        if(stackMin.size() == 0){
            return -1;
        }
        return stackMin.peek();
    }
}
