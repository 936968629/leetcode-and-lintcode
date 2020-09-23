package leetcode._001_100._006;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (char item : s.toCharArray()) {
            rows.get(i).append(item);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder item : rows) {
            res.append(item);
        }
        return res.toString();
    }

}
