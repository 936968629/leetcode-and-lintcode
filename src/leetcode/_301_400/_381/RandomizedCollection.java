package leetcode._301_400._381;

import java.util.*;

public class RandomizedCollection {

    private int size;

    private Map<Integer, Set<Integer>> map;

    private List<Integer> list;

    public RandomizedCollection() {
        size = 0;
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(size);
        list.add(val);
        size++;
        return map.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) {
            return false;
        }
        Integer next = map.get(val).iterator().next();
        map.get(val).remove(next);
        int last = list.get(list.size()-1);
        list.set(next, last);
        map.get(last).add(next);
        map.get(last).remove(list.size()-1);

        list.remove(list.size()-1);
        size--;
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i);
    }

}
