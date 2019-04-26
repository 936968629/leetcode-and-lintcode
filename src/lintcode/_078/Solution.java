package lintcode._078;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        // write your code here
        int length = strs.length;
        if (length == 0){
            return "";
        }
        if (length == 1){
            return strs[0];
        }
        int MIN_LENGTH = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (strs[i].length() < MIN_LENGTH) {
                MIN_LENGTH = strs[i].length();
            }
        }
        String pre = "";
        for (int i = 0; i < MIN_LENGTH; i++) {
            int count = 0;
            String item = "";
            for (int j = 1; j < length; j++) {
                if (strs[j].charAt(i) == strs[j-1].charAt(i)){
                    count++;
                    item = String.valueOf(strs[j].charAt(i));
                }
            }
            if (count == length-1){
                pre = pre + item;
            }

        }
        return pre;

    }

}
