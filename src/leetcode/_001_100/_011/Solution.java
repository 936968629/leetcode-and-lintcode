package leetcode._001_100._011;

public class Solution {

    public int maxArea(int[] height) {
        int length = height.length;
        if (length <= 1) {
            return 0;
        }
        int res= 0;
        int left = 0;
        int right = length -1;
        while (left <= right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right-left));
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}
