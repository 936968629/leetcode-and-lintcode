package lintcode._401_500._407;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] plusOne(int[] digits) {
        // write your code here
        if ( digits.length == 0 ) {
            int[] res = new int[1];
            res[0] = 1;
            return res;
        }
        int length = digits.length;
        List<Integer> result = new ArrayList<>();
        reverse(digits);
        int signal = 1;
        for (int i = 0; i < length; i++) {
            int sum = digits[i] + signal;
            if ( sum >= 10 ) {
                signal = 1;
                sum = sum % 10;
            } else {
                signal = 0;
            }
            result.add(sum);
        }
        if ( signal > 0 ) {
            result.add(signal);
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        reverse(res);
        return res;
    }

    public void reverse(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while ( i < j ) {
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
