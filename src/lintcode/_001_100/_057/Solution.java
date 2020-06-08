package lintcode._001_100._057;

import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (numbers.length < 3){
            return res;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {

            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }

            int low = i+1;
            int high = numbers.length - 1;
            while (low < high){
                if (numbers[low] + numbers[high] + numbers[i] == 0){
                    ArrayList<Integer> triple = new ArrayList<>();
                    triple.add(numbers[i]);
                    triple.add(numbers[low]);
                    triple.add(numbers[high]);
                    res.add(triple);
                    low++;
                    high--;

                    while (low < high && numbers[low] == numbers[low-1]){
                        low++;
                    }
                    while (low < high && numbers[high] == numbers[high+1]){
                        high--;
                    }
                }else if (numbers[low] + numbers[high] + numbers[i] > 0){
                    high--;
                }else{
                    low++;
                }
            }

        }
        return res;
    }


    public List<List<Integer>> threeSum2(int[] numbers) {
        // write your code here
        Set<List<Integer>> res = new HashSet<>();
        int length = numbers.length;
        if ( length < 3 ) {
            return new ArrayList<>(res);
        }
        Arrays.sort(numbers);
//        dfs(numbers, 0, 3,0,new ArrayList<>(), res);
        return new ArrayList<>(res);
    }

    public void dfs2(int[] numbers, int index, List<Integer> item, List<List<Integer>> res) {
        if ( item.size() == 3 && item.get(0) + item.get(1) + item.get(2) == 0 ) {
            res.add(new ArrayList<>(item));
            return;
        }
        if ( item.size() == 3 ) {
            return;
        }
        for (int i = index; i < numbers.length; i++) {
            if ( i > index && numbers[i] == numbers[i-1] ) {
                continue;
            }
            item.add(numbers[i]);
            dfs2(numbers, i+1, item, res);
            item.remove(item.size()-1);
        }
    }
}
