package lintcode._101_200._122;

import java.util.Stack;

public class Solution {

    class Command {

        public int index;

        public int val;

        public Command(int index, int val) {
            this.index = index;
            this.val = val;
        }

    }

    public int largestRectangleArea(int[] height) {
        // write your code here

        int length = height.length;
        if (length == 0){
            return 0;
        }
        int maxArea = 0;


        Stack<Command> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while ( !stack.isEmpty() && height[i] < stack.peek().val ) {
                Command item = stack.pop();
                maxArea = Math.max(maxArea, item.val * ( stack.isEmpty() ? i : (i-stack.peek().index-1) ) );
            }
            stack.push(new Command(i, height[i]));
        }

        while ( !stack.isEmpty() ) {
            Command item = stack.pop();
            int k = stack.empty() ? -1:stack.peek().index;
            maxArea = Math.max(item.val * (length - k - 1), maxArea);
        }

        return maxArea;

//        int length = height.length;
//        if (length == 0){
//            return 0;
//        }
//        int maxArea = 0;
//        for (int i = 0; i < length; i++) {
//            int min = height[i];
//            for (int j = i; j < length; j++) {
//                min = Math.min(min, height[j]);
//                maxArea = Math.max(maxArea, min * (j-i+1));
//            }
//        }
//        return maxArea;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {2,3,5,8,4,1};
        sol.largestRectangleArea(height);
    }

}
