package lintcode._124;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {

    public int longestConsecutive(int[] num) {
        // write your code here
        int length = num.length;
        if (length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(num[i]);
        }
        int count = Integer.MIN_VALUE;
        for (int n : num){
            set.remove(n);
            int ncount = 1;
            int left = n - 1;
            while (set.contains(left)){
                set.remove(left);
                left = left - 1;
                ncount++;
            }

            int right = n + 1;
            while (set.contains(right)){
                set.remove(right);
                right = right+1;
                ncount++;
            }

            count = Math.max(count,ncount );
        }
        System.out.println(count);
        return count;


    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] num = {1,2,2,2,2,3,5,1,1,5};
        sol.longestConsecutive(num);
    }
}
