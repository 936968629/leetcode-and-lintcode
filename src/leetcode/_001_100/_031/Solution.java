package leetcode._001_100._031;

public class Solution {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return;
        }
        int i = length - 1;
        while (i > 0) {
            if (nums[i] > nums[i-1]) {
                break;
            }
            i--;
        }
        if (i == 0) {
            reverse(nums, 0, length-1);
            return;
        }
        int j = i - 1;
        int end = length - 1;
        while (nums[j] > nums[end]) {
            end--;
        }
        swap(nums, j, end);
        reverse(nums, i, length - 1);
    }

    public void reverse(int[] nums ,int start, int end) {
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
