package lintcode._401_500._420;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String countAndSay(int n) {
        // write your code here
        List<String> list = new ArrayList<>();

        String s = "1";

        for (int i = 1; i < n; i++) {
            s = readString(s);
        }

        return s;
    }

    private String readString(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        String str = "";

        for (int i = 0; i < chars.length; i++) {
            if (i == 0 || chars[i] == chars[i - 1]) {
                count++;
            } else {
                str += count + "" + chars[i - 1];
                count = 1;
            }
        }

        str += count + "" + chars[chars.length - 1];

        return str;
    }

}
