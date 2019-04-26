package lintcode._122;

import java.util.Stack;

public class Solution {


    public int largestRectangleArea(int[] height) {
        // write your code here
        int length = height.length;
        if (length == 0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.empty() && height[i] <= height[stack.peek()]){
                int temp = stack.pop();
                int area = height[temp] * (stack.empty() ? i:(i-stack.peek()-1));
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while (!stack.empty()){
            int j = stack.pop();
            int k = stack.empty() ? -1:stack.peek();
            int area = height[j] * (height.length - k - 1);
            maxArea = Math.max(area, maxArea );
        }
        System.out.println(maxArea);
        return maxArea;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {2,3,5,8,4,1};
        sol.largestRectangleArea(height);
    }

}
