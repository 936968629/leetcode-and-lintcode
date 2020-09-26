package leetcode._001_100._027;

public class Solution {

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < length; j++) {
            if (nums[j] == val) {
                continue;
            }else {
                swap(nums, i, j);
                i++;
            }
        }
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int removeElement2(int[] nums, int val) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (val == nums[i]) {
                continue;
            }
            nums[start] = nums[i];
            start++;
        }
        return start;
    }

}
