package leetcode._692;

import java.util.*;

public class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();

        List<String> result = new ArrayList<>();
        for(String item : words) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            }else {
                map.put(item, 1);
            }
        }

        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                 if (o1.getValue().equals(o2.getValue())) {
                     return o1.getKey().compareTo(o2.getKey());
                 }else {
                     return o2.getValue() - o1.getValue();
                 }
            }
        });

        for (Map.Entry<String, Integer> item : map.entrySet()) {
            queue.offer(item);
        }

        for (int i = 0; i < k; i++) {
            result.add(queue.poll().getKey());
        }

        return result;
    }

}
