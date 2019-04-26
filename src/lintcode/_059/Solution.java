package lintcode._059;

import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        int close = Integer.MAX_VALUE;
        if (numbers.length < 3){
            return -1;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int low = i+1;
            int high = numbers.length - 1;
            while (low < high){
                int res = numbers[i] + numbers[low] + numbers[high];
                if (Math.abs(res-target) < Math.abs(close-target)){
                    close = res;
                }
                if (res > target){
                    high--;
                }else{
                    low++;
                }
            }
        }
        return close;
    }

}
