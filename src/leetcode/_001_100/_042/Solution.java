package leetcode._001_100._042;

public class Solution {

    public int trap(int[] height) {
        int length = height.length;
        if (length <= 1) {
            return 0;
        }
        int res= 0;
        for (int i = 1; i < length-1; i++) {
            int leftMax= 0;
            int rightMax= 0;
            for (int j = i; j < length; j++) {
                rightMax = Math.max(height[j], rightMax);
            }
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(height[j], leftMax);
            }

            res += Math.min(rightMax, leftMax) - height[i];
        }

        return res;
    }

}
