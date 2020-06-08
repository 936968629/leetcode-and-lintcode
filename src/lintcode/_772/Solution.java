package lintcode._772;

import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        // write your code here
        Map<String, List<String>> map = new HashMap<>();
        for(String item : strs){
            char[] chars = item.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (map.containsKey(s)){
                map.get(s).add(item);
            }else{
                map.put(s, new ArrayList<>());
                map.get(s).add(item);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        solution.groupAnagrams(strs);
    }

}
