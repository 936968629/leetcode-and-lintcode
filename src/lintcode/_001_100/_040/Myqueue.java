package lintcode._001_100._040;

import java.util.Stack;

public class Myqueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public Myqueue(){

    }

    public void push(int x){
        this.stack1.push(x);
    }

    public int pop(){
        if(this.stack2.size() == 0) {
            while(!this.stack1.empty()){
                Integer item = this.stack1.pop();
                this.stack2.push(item);
            }
        }

        return this.stack2.empty() ? -1:this.stack2.pop();
    }

    public int top(){
        if (this.stack2.empty()) {
            while (!this.stack1.empty()) {
                Integer item = this.stack1.pop();
                this.stack2.push(item);
            }
        }

        return this.stack2.empty() ? -1 : this.stack2.peek();
    }


    public static void main(String[] args) {
//        lintcode._040.Myqueue myqueue = new lintcode._040.Myqueue();
//        myqueue.push(1);
//        myqueue.pop();
//        myqueue.push(2);
//        myqueue.push(3);
//        myqueue.top();
//        myqueue.pop();
    }

}
