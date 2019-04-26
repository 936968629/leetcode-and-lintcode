package lintcode._056;

import java.util.*;

public class Solution {


    public int[] twoSum(int[] numbers, int target) {
        // write your code here

        Map<Integer, Integer> map = new HashMap<>();

//        Collections.sort(numbers, );
        int[] res = new int[2];

        for (int i=0;i<numbers.length;i++){
            if (map.containsKey(numbers[i])){
                res[0] = map.get(numbers[i]);
                res[1] = i;
                break;
            }else{
                map.put(target-numbers[i], i);
            }

        }
        return res;
    }

}
