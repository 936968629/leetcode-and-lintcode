package lintcode._189;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int firstMissingPositive(int[] A) {
        // write your code here
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (A[i] > 0 || A[i] <= len ){
                map.put(A[i], 1);
            }
        }

        for (int i = 1; i <= len+1; i++) {
            if (!map.containsKey(i)){
                return i;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {1,3};
        int res = sol.firstMissingPositive(A);
        System.out.println(res);
    }

}
