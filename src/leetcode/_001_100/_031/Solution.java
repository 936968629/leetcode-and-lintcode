package leetcode._001_100._031;

public class Solution {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return;
        }
        int right = length - 1;
        while (right > 0) {
            if (nums[right] > nums[right-1]) {
                break;
            }
            right--;
        }
        if (right == 0) {
            reverse(nums, 0, length - 1);
            return;
        }
        int last = right - 1;
        int end = length - 1;
        while (nums[last] > nums[end]) {
            end--;
        }
        swap(nums, last, end);
        reverse(nums, right, length - 1);
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
