package lintcode._101_200._134;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache  {

    private final int cacheSize;

    private LinkedHashMap<Integer, Integer> map;

    /*
     * @param capacity: An integer
     */
    public LRUCache(int capacity) {
        // do intialization if necessary
        cacheSize = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        map.put(key, value);
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2, 1);
        lruCache.set(1, 1);
        lruCache.get(2);
        lruCache.set(4, 1);
        lruCache.get(1);
        lruCache.get(2);
    }
}
