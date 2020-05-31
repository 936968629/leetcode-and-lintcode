package lintcode._001_100._078;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if ( strs.length == 0 ) {
            return "";
        }
        if ( strs.length == 1 ) {
            return strs[0];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
        }
        String res = "";
        for (int i = 0; i < min; i++) {
            int count = 0;
            String item = "";
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if ( strs[j].charAt(i) == c ) {
                    count++;
                    item = String.valueOf(c);
                }
            }
            if ( count == strs.length -1 ) {
                res += item;
            }
        }
        return res;

    }

}
