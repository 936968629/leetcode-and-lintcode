package lintcode._012;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stackNum = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();

    MinStack(){

    }

    public void push(int x)
    {
        this.stackNum.push(x);
        if (this.stackMin.empty()){
            this.stackMin.push(x);
        }else {
            int min = this.stackMin.peek();
            if (min > x) {
                this.stackMin.push(x);
            } else {
                this.stackMin.push(min);
            }
        }

    }

    public int pop(){
        if (this.stackNum.empty()) {
            return -1;
        }
        this.stackMin.pop();
        return this.stackNum.pop();
    }

    public int min(){
        if (this.stackMin.empty()) {
            return -1;
        }
        return this.stackMin.peek();
    }

}
