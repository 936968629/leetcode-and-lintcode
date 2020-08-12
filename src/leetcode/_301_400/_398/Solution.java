package leetcode._301_400._398;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {

    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                result.add(i);
            }
        }
        return result.get(new Random().nextInt(result.size()));
    }

}
