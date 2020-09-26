package leetcode._001_100._017;

import java.util.*;

public class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        dfs(result, new StringBuilder(), digits, 0, map);
        return result;
    }

    public void dfs(List<String> result, StringBuilder item, String digits, int index, Map<String, String> map) {
        if (index == digits.length()) {
            result.add(item.toString());
            return;
        }
        String s = map.get(String.valueOf(digits.charAt(index)));
        for (int j = 0; j < s.length(); j++) {
            item.append(s.charAt(j));
            dfs(result, item, digits,index+1, map);
            item.deleteCharAt(item.length()-1);
        }

    }

    public void dfs2(List<String> result, StringBuilder sb, int index, String digits, Map<String, String> map) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (int i = index; i < digits.length(); i++) {
            String s = map.get(String.valueOf(digits.charAt(i)));
            for (int j = 0; j < s.length(); j++) {
                sb.append(s.charAt(j));
                dfs2(result, sb, i+1, digits, map);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.letterCombinations("22");
        System.out.println(list.toString());
    }
}
