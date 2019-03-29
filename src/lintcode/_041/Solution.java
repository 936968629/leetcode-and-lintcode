package lintcode._041;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public int maxSubArray(int[] nums) {
        // write your code here

//        int length = nums.length;
//        if (length == 0){
//            return 0;
//        }
//        int[] res = new int[length];
//        res[0] = nums[0];
//        for (int i = 1;i<length;i++){
//            res[i] = Math.max(res[i-1]+nums[i], nums[i]);
//        }
//        return Arrays.stream(res).max().getAsInt();

        if (nums.length == 0){
            return 0;
        }
        int res = nums[0];
        int per = nums[0];
        for (int i = 1; i < nums.length; i++) {
            per = Math.max(nums[i], per+nums[i]);
            res = Math.max(res, per);
        }
        return res;
    }

}
