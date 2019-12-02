package lintcode._424;

import java.util.Stack;

public class Solution {

    public int evalRPN(String[] tokens) {
        // write your code here

        Stack<Integer> stack = new Stack<>();

        for (String item : tokens){
            if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")){
                int popItem1 = stack.pop();
                int popItem2 = stack.pop();
                if (item.equals("+")){
                    stack.push(popItem1 + popItem2);
                }else if (item.equals("-")){
                    stack.push(popItem2 - popItem1);
                }else if (item.equals("*")){
                    stack.push(popItem1 * popItem2);
                }else if (item.equals("/")){
                    stack.push(popItem2 / popItem1);
                }
            }else{
                stack.push(Integer.valueOf(item));
            }
        }

        return stack.pop();

    }

}
