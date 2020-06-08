package lintcode._001_100._039;

import java.util.Collections;
import java.util.List;

public class Solution {

    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        if ( nums == null || nums.size() < 2 ) {
            return;
        }
        int length = nums.size();
        for (int i = 1; i < length; i++) {
            if ( nums.get(i) < nums.get(i-1) ) {
                reverse(nums, 0, i-1);
                reverse(nums, i, nums.size()-1);
                reverse(nums, 0, nums.size()-1);
            }
        }
    }

    private void reverse(List<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }

}
