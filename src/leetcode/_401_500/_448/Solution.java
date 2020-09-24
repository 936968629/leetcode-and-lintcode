package leetcode._401_500._448;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int item = Math.abs(nums[i]);
            if (nums[item-1] > 0) {
                nums[item-1] = -nums[item-1];
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,3,2,7,8,2,3,1};
        solution.findDisappearedNumbers(nums);
    }
}
