package lintcode._171;

import java.util.*;

public class Solution {

    public List<String> anagrams(String[] strs) {
        // write your code here
        int length = strs.length;
        if (length == 0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            if (entry.getValue().size() > 1){
                res.addAll(entry.getValue());
            }
        }
        return res;
    }

}
