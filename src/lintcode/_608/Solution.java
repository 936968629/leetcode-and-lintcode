package lintcode._608;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int[] res = new int[2];
        int length = nums.length;
        if (length < 2){
            return res;
        }
        if (target < nums[0]){
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {

            if (map.containsKey(nums[i])){
                res[0] = map.get(nums[i]);
                res[1] = i+1;
                return res;
            }else{
                map.put(target-nums[i], i+1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,0,1};
        int target = 0;
        solution.twoSum(nums, target);
    }

}
