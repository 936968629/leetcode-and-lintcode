package lintcode._301_400._363;

import java.util.ArrayList;
import java.util.List;
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

    public int trapRainWater(int[] heights) {
        // write your code here

        int length = heights.length;
        if (length == 0) {
            return 0;
        }

        Stack<Command> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < length; i++) {
            while ( !stack.isEmpty() && stack.peek().val <= heights[i] ) {
                Command peek = stack.pop();
                if ( !stack.isEmpty() ) {
                    Command item = stack.peek();
                    res += (Math.min(heights[i], item.val) - peek.val) * (i - item.index - 1);
                }
            }
            stack.push(new Command(i, heights[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {1,2,3,4};
        sol.trapRainWater(height);
    }

}
