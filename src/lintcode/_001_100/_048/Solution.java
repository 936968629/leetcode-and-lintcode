package lintcode._001_100._048;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int majorityNumber(List<Integer> nums, int k) {
        // write your code here
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer item : nums) {
            if ( map.containsKey(item) ) {
                map.put(item, map.get(item)+1);
            }else{
                map.put(item, 1);
            }
        }
        for ( Map.Entry<Integer,Integer> item:map.entrySet()) {
            if ( item.getValue() > nums.size()/k ) {
                return item.getKey();
            }
        }
        return -1;
    }
}
