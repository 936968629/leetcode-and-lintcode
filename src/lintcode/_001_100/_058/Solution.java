package lintcode._001_100._058;

import java.util.*;

public class Solution {

//    Time Limit Exceeded

    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        int length = numbers.length;
        if ( length < 4 ) {
            return new ArrayList<>(res);
        }
        Arrays.sort(numbers);
        dfs(numbers, 0, target,new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] numbers, int index, int target, List<Integer> item, List<List<Integer>> res ) {
        if ( item.size() == 4 && item.get(0) + item.get(1) + item.get(2) + item.get(3) == target ) {
            res.add(new ArrayList<>(item));
            return;
        }
        if ( item.size() == 4 ) {
            return;
        }
        for (int i = index; i < numbers.length; i++) {
            if ( i > index && numbers[i] == numbers[i-1] ) {
                continue;
            }
            item.add(numbers[i]);
            dfs(numbers, i+1, target, item, res);
            item.remove(item.size()-1);
        }
    }


}
