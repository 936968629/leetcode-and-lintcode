package lintcode._082;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int singleNumber(int[] A) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i < A.length; i++){
            if (map.containsKey(A[i])){
                map.remove(A[i]);
            } else{
                map.put(A[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            return entry.getKey();
        }
        return -1;
    }

}
