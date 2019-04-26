package lintcode._124;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {

    public int longestConsecutive(int[] num) {
        // write your code here
        int length = num.length;
        if (length == 0){
            return 0;
        }
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(num[i], 1);
        }
        int max = Integer.MIN_VALUE;

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
        while ( iterator.hasNext() ){
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer i = (Integer) next.getKey();
            Integer j = i;
            int count = 1;
            while (map.get(j-1) != null){
                map.remove(j-1);
                j = j -1;
                count++;
            }
            Integer k = i;
            while (map.get(k+1) != null){
                map.remove(k+1);
                k = k + 1;
                count++;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] num = {1,2,2,2,2,3,5,1,1,5};
        sol.longestConsecutive(num);
    }
}