package leetcode._201_300._202;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = getN(n);
        }
        return true;
    }

    public int getN(int n) {
        int res = 0;
        while (n > 0) {
            res += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return res;
    }

}
