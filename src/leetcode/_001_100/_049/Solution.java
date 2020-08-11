package leetcode._001_100._049;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int length = strs.length;
        if (length == 0) {
            return new ArrayList<>();
        }
        for (int i = 0; i < length; i++) {
            char[] item = strs[i].toCharArray();
            Arrays.sort(item);
            String key = String.valueOf(item);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            }else {
                List<String> res = new ArrayList<>();
                res.add(strs[i]);
                map.put(key, res);
            }
        }

        return new ArrayList(map.values());
    }

}
