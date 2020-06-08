package lintcode._994;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findMaxLength(int[] nums) {
        // Write your code here
        if (nums.length < 2){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                nums[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)){
                res = Math.max(res, i - map.get(sum));
            }else{
                map.put(sum, i);
            }
        }

        return res;
    }

}
