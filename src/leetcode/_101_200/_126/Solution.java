package leetcode._101_200._126;

import java.util.*;

public class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return result;
        }
        Set<String> visited = new HashSet<>();

        Queue<List<String>> queue = new LinkedList<>();
        List<String> startList = new ArrayList<>();
        startList.add(beginWord);
        queue.offer(startList);
        visited.add(beginWord);

        boolean isFind = false;

        while (!queue.isEmpty() && !isFind) {
            int size = queue.size();

            Set<String> itemSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> poll = queue.poll();
                String item = poll.get(poll.size()-1);
                char[] chars = item.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if(ch == c) {
                            continue;
                        }
                        chars[j] = c;
                        String newStr = String.valueOf(chars);
                        if (!visited.contains(newStr) && set.contains(newStr)) {
                            List<String> pathList = new ArrayList<>(poll);
                            pathList.add(newStr);
                            if (newStr.equals(endWord)) {
                                isFind = true;
                                result.add(new ArrayList<>(pathList));
                            }
                            queue.offer(pathList);
                            itemSet.add(newStr);
                        }
                    }
                    chars[j] = ch;
                }
            }
            visited.addAll(itemSet);
        }

        return result;
    }

}
