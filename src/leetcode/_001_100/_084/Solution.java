package leetcode._001_100._084;

import java.util.Stack;

public class Solution {

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return heights[0];
        }
        int[] newHeights = new int[length+2];
        newHeights[0] = 0;
        for (int i = 1; i < length+1; i++) {
            newHeights[i] = heights[i-1];
        }
        newHeights[length+1] = 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < length+2; i++) {
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                int curIndex = stack.pop();
                res = Math.max(res, newHeights[curIndex] * (i-stack.peek()-1));
            }
            stack.push(i);
        }
        return res;
    }

    public int largestRectangleArea2(int[] heights) {
        int length = heights.length;
        if (length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            int left = i;
            int right = i;
            int height = heights[i];
            while (left >= 0 && heights[left] >= height) {
                left--;
            }
            while (right <= length - 1 && heights[right] >= height) {
                right++;
            }
            int width = right - left - 1;
            max = Math.max(width * height, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {2,1,2};
        solution.largestRectangleArea(height);
    }

}
