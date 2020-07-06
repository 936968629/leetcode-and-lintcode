package leetcode._001_100._034;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int length = nums.length;
        if (length == 0) {
            res[0] = res[1] = -1;
            return res;
        }
        int left = 0;
        int right = length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            }else if (nums[mid] < target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < length; i++) {
            if ( nums[i] == target ) {
                result.add(i);
            }
        }
        if ( result.size() == 0 ) {
            res[0] = res[1] = -1;
        }else {
            res[0] = result.get(0);
            res[1] = result.get(result.size()-1);
        }

        return res;
    }

}
