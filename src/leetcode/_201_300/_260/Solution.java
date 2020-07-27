package leetcode._201_300._260;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {

    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            res[i] = next;
            i++;
        }
        return res;
    }

}
