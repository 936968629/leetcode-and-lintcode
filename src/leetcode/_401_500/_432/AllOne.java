package leetcode._401_500._432;

import java.util.*;

public class AllOne {

    Map<String, Integer> map;

    List<Set<String>> list;

    public AllOne() {
        map = new HashMap<>();
        list = new ArrayList<>();
        list.set(0, new HashSet<>());
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!map.containsKey(key)) {
            map.put(key, 1);
        }else {
            map.put(key, map.get(key)+1);
        }

    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {

    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return null;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return null;
    }

}
