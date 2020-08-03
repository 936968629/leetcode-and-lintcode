package leetcode._001_100._005;

import java.util.*;

public class Solution {

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int maxLen = 0;
        int begin = 0;
        for(int j=1; j< length; j++) {
            for(int i=0; i<j; i++) {
                if(s.charAt(i) != s.charAt(j))
                {
                    dp[i][j] = false;
                } else {
                    // 两端相等，且长度小于等于3，必为回文串
                    if(j-i < 3)     // 当前字符串长度小于等于3（子串为0或1）
                    {
                        dp[i][j] = true;
                    }
                    // 两端相等，是否为回文，取决于其子串
                    else
                    {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && (j-i+1>maxLen))
                {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public String longestPalindrome2(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        String res= s.substring(0,1);
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (dp[i+1][j-1] || j-i < 2)) {
                    dp[i][j] = true;
                }else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    if (res.length() < j-i+1) {
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreadLocal<String> mmap = new ThreadLocal<>();
        mmap.set("dsa");
        System.out.println(mmap.get());

        ThreadLocal<String> mmap2 = new ThreadLocal<>();
        mmap2.set("dsaa");

        new LinkedHashMap<>();
        new WeakHashMap<>();
        new TreeMap<>();

        new ArrayList<>();
        new TreeSet<>();
    }

}
