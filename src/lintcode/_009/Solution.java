package lintcode._009;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1 ; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                result.add("fizz buzz");
            } else if (i % 3 == 0) {
                result.add("fizz");
            } else if (i % 5 == 0) {
                result.add("buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }

    public static void main(String arg[]) {
        int n = 15;
        Solution sol = new Solution();
        System.out.println(sol.fizzBuzz(n));
    }
}
