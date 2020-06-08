package lintcode._1032;

import java.util.*;

public class Solution {

    public List<String> letterCasePermutation(String S) {
        // write your code here
        //bfs
        int length = S.length();
        if ( S == null ) {
            return new ArrayList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        for (int i = 0; i < length; i++) {
            if ( Character.isDigit(S.charAt(i)) ) {
                continue;
            }
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String item = queue.poll();
                char[] chars = item.toCharArray();
                chars[i] = Character.toLowerCase(chars[i]);
                queue.offer(String.valueOf(chars));
                chars[i] = Character.toUpperCase(chars[i]);
                queue.offer(String.valueOf(chars));
            }
        }

        return new ArrayList<>(queue);
    }

    public List<String> letterCasePermutation2(String S) {
        // write your code here
        int length = S.length();
        if ( S == null ) {
            return new ArrayList<>();
        }
        //dfs
        List<String> result = new ArrayList<>();
        dfs(result, 0, S.toCharArray());
        return result;
    }

    public void dfs(List<String> result, int index, char[] chars) {
        if ( index == chars.length ) {
            result.add(String.valueOf(chars));
            return;
        }
        char item = chars[index];
        if ( Character.isDigit(item) ) {
            dfs(result, index + 1, chars);
        }else {
            chars[index] = Character.toLowerCase(chars[index]);
            dfs(result, index + 1, chars);
            chars[index] = Character.toUpperCase(chars[index]);
            dfs(result, index + 1, chars);
            chars[index] = item;
        }
    }

}
