package leetcode._001_100._005;

public class Solution {

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        boolean[][] dp = new boolean[length+1][length+1];
        for (int i = 0; i < length + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i < length + 1; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < length + 1; j++) {

            }
        }


        return "";
    }

    public static void main(String[] args) {
        ThreadLocal<String> mmap = new ThreadLocal<>();
        mmap.set("dsa");
        System.out.println(mmap.get());

        ThreadLocal<String> mmap2 = new ThreadLocal<>();
        mmap2.set("dsaa");
    }

}
