package leetcode._001_100._042;

import java.util.Stack;

public class Solution {

    public int trap(int[] height) {
        // [0,1,0,2,1,0,1,3,2,1,2,1]
        int length = height.length;
        if (length <= 1) {
            return 0;
        }
        int res= 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIndex = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[curIndex]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    Integer stackPop = stack.peek();
                    res += (Math.min(height[i], height[stackPop]) - height[curIndex] ) * (i-curIndex+1);
                }
            }
            stack.push(i);
        }
        return res;
    }




    public static void main(String[] args) {

    }

}
