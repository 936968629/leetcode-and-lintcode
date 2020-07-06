package leetcode._301_400._349;

import java.util.*;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if ( set.contains(nums2[i]) ) {
                set2.add(nums2[i]);
            }
        }
        int[] res = new int[set2.size()];
        Iterator<Integer> iterator = set2.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            res[i] = next;
            i++;
        }
        return res;
    }

}
