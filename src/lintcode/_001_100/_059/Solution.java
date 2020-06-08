package lintcode._001_100._059;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int threeSumClosest2(int[] numbers, int target) {
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

    private int min = Integer.MAX_VALUE;
    private int res;

    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if ( numbers.length < 3 ) {
            return 0;
        }
        dfs(numbers, 0, new ArrayList<>(), target);
        return res;
    }

    public void dfs(int[] numbers, int index,List<Integer> item, int target) {
        if ( item.size() == 3 ) {
            int sum = item.get(0) + item.get(1) + item.get(2);
            if ( Math.abs(sum-target) < min ) {
                min = Math.abs(sum-target);
                res = sum;
            }
            return;
        }
        for (int i = index; i < numbers.length; i++) {
            item.add(numbers[i]);
            dfs(numbers, i+1, item, target);
            item.remove(item.size()-1);
        }

    }

}
