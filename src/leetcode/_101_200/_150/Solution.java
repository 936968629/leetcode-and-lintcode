package leetcode._101_200._150;

import java.util.Stack;

public class Solution {

    public int evalRPN(String[] tokens) {
        //    +, -, *, /
        Stack<Integer> stack = new Stack<>();

        int length = tokens.length;
        for (int i = 0; i < length; i++) {
            String item = tokens[i];
            if (item.equals("+") || item.equals("-") || item.equals("/") || item.equals("*")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                int total;
                switch (item) {
                    case "+":
                        total = a + b;
                        stack.push(total);
                        break;
                    case "-":
                        total = a - b;
                        stack.push(total);
                        break;
                    case "*":
                        total = a * b;
                        stack.push(total);
                        break;
                    case "/":
                        total = b / a;
                        stack.push(total);
                        break;
                }
            }else {
                stack.push(Integer.valueOf(item));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {

        String[] a = {"4","13","5","/","+"};
        Solution solution = new Solution();
        solution.evalRPN(a);
    }

}
