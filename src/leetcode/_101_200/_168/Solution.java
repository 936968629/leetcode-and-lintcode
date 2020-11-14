package leetcode._101_200._168;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public String convertToTitle(int n) {

        StringBuilder res = new StringBuilder();
        while (n > 0) {
            n--;
            res.append((char)('A' + n % 26));
            n = n / 26;
        }

        return res.reverse().toString();
    }
}
