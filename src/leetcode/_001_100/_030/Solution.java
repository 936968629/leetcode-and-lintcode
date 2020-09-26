package leetcode._001_100._030;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int length = words.length;
        if (length == 0) {
            return result;
        }
        int itemLen = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            }else {
                map.put(words[i], 1);
            }
        }

        for (int i = 0; i < length - itemLen; i++) {
            String substring = s.substring(i, i + itemLen);
            if (!map.containsKey(substring)) {
                return new ArrayList<>();
            }else {

            }
        }


        return result;
    }

}
