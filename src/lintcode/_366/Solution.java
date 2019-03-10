package lintcode._366;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int fibonacci(int n) {
        // write your code here
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        for (int i = 2; i < n;i++) {
            result.add(result.get(i-1) + result.get(i-2));
        }
        return result.get(n-1);
    }

}
