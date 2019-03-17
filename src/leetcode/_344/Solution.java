package com.leetcode._344;

import java.util.*;

public class Solution {
    
    public void reverseString(char[] s) {
        int length = s.length;
        int i = 0;
        int j = length-1;
        while (i<j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i += 1;
            j -= 1;
        }
        System.out.println(s);
    }

    public void reverseString2(String s) {
        int length = s.length();
        int i = 0;
        int j = length-1;
        char[] chars = s.toCharArray();
        while (i<j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i += 1;
            j -= 1;
        }
        System.out.println(chars);
    }

    public static void main(String arg[]){
        Set<String> ss = new TreeSet<>();
        char[] str = {'h','e','l','l','o'};
        String str2 = "hello";
        Solution sol = new Solution();
        sol.reverseString(str);
        sol.reverseString2(str2);

    }
}
