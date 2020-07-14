package leetcode._001_100._075;

public class Solution {

    public void sortColors(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return;
        }
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                num0++;
            }else if (nums[i] == 1) {
                num1++;
            }else {
                num2++;
            }
        }
        int j = 0;
        for (int i = 0; i < num0; i++) {
            nums[j] = 0;
            j++;
        }
        for (int i = 0; i < num1; i++) {
            nums[j] = 1;
            j++;
        }
        for (int i = 0; i < num2; i++) {
            nums[j] = 2;
            j++;
        }
    }

}
