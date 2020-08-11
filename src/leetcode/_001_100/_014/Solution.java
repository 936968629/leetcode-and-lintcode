package leetcode._001_100._014;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return strs[0];
        }
        int mimLength = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            mimLength = Math.min(strs[i].length(), mimLength);
        }
        if (mimLength == 0) {
            return "";
        }
        int index = 0;
        Character ch = ' ';
        for (int i = 0; i < mimLength; i++) {
            for (int j = 0; j < length; j++) {
                String item = strs[j];
                if (j == 0) {
                    ch = item.charAt(i);
                }else {
                    if (item.charAt(i) != ch) {
                        if (index == 0) {
                            return "";
                        }
                        return strs[0].substring(0,index);
                    }
                }
                index = i;
            }
        }
        return strs[0].substring(0,index+1);
    }

}
