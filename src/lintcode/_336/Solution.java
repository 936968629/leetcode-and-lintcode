package lintcode._336;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int fibonacci(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int[] result = new int[n];
        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i < n; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[n-1];

    }


}
