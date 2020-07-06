package lintcode._401_500._488;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isHappy(int n) {
        // write your code here
        Set<Integer> set = new HashSet<>();

        while ( true ) {
            if ( n == 1 ) {
                return true;
            }
            n = sum(n);
            if ( set.contains(n) ) {
                return false;
            }
            set.add(n);
        }

    }

    private int sum(int n) {
        int res = 0;
        while ( n > 0 ) {
            int m = n % 10;
            res += m * m;
            n = n / 10;
        }
        return res;
    }

}
