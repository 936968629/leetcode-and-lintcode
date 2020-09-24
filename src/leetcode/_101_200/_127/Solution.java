package leetcode._101_200._127;

import java.util.*;

public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String item = queue.poll();
                char[] chars = item.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        if (String.valueOf(chars).equals(endWord)) {
                            visited.add(String.valueOf(chars));
                            return count + 1;
                        }
                        if (!visited.contains(String.valueOf(chars)) && set.contains(String.valueOf(chars))) {
                            queue.offer(String.valueOf(chars));
                            visited.add(String.valueOf(chars));
                        }
                    }
                    chars[j] = ch;
                }
            }
            count++;
        }

        return 0;
    }

}
