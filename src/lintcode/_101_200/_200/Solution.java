package lintcode._101_200._200;

public class Solution {

    public String longestPalindrome(String s) {
        // write your code here
        char[] chars = s.toCharArray();
        int stringLen = chars.length;
        boolean[][] len = new boolean[stringLen][stringLen];
        int start = 0;
        int end = 0;
        for (int i = 0; i < stringLen; i++) {
            for (int j = 0; j < stringLen - 1; j++) {
                if (i == 0){
                    len[j][j] = true;
                }else if (i == 1){
                    if (chars[j] == chars[j+1]){
                        len[j][j+i] = true;
                    }
                }else{
                    if(chars[j] == chars[j + i] && len[j + 1][j + i - 1]) {
                        len[j][j + i] = true;
                    }
                }
                if(len[j][j + i] == true) {
                    start = j;
                    end = j + i;
                }
            }

        }

        return s.substring(start, end+1);


    }

}
