package leetcode._101_200._189;

public class Solution {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length == 1) {
            return;
        }
        k = k % length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, length-1);
    }

    public void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        while (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
