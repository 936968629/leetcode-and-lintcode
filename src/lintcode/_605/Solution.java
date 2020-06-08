package lintcode._605;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();

        for(int item : org){
            map.put(item, new HashSet<>());
            degree.put(item, 0);
        }
        
        return false;
    }

}
