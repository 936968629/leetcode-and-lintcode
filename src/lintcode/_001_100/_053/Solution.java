package lintcode._001_100._053;

import java.util.Arrays;

public class Solution {

    public String reverseWords(String s) {
        // write your code here
        s = s.trim();
        String[] strs = s.split("\\s+");
        reverse(strs);
        return String.join(" ", strs);
    }

    public void reverse(String[] strs){
        int start = 0;
        int end = strs.length - 1;
        while (start <= end){
            String temp = strs[start];
            strs[start] = strs[end];
            strs[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
//        lintcode._053.Solution sol = new lintcode._053.Solution();
//        String s = "the sky is    blue";
//        String res = sol.reverseWords(s);
//        System.out.println(res);
    }

}
