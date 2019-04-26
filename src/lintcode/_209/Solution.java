package lintcode._209;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    public char firstUniqChar(String str) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();
        for (char i : str.toCharArray()){
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
//
//        for (Character i : map.keySet()){
//            if (map.get(i) == 1)
//                return i;
//        }
        for(Map.Entry<Character, Integer> entry:map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return new Character(' ');

    }

}
