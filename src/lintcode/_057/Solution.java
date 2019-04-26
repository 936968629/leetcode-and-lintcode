package lintcode._057;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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



}
