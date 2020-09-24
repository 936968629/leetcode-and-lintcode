package leetcode._301_400._376;

public class Solution {

    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        //up[i] 第i个元素结尾的上升摆动序列的长 down[i] 第i个元素结尾的下降摆动序列的长
        int[] up = new int[length + 1];
        int[] down = new int[length + 1];
        up[0] = 0;
        down[0] = 0;
        up[1] = 1;
        down[1] = 1;

        for (int i = 2; i < length + 1; i++) {
            if (nums[i-1] > nums[i-2]) {
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            }else if (nums[i-1] < nums[i-2]) {
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            }else {
                up[i]= up[i-1];
                down[i] = down[i-1];
            }
        }

        return Math.max(up[length], down[length]);
    }

}
