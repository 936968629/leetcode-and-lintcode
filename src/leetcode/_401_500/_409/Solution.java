package leetcode._401_500._409;

public class Solution {

    public int longestPalindrome(String s) {
        int[] temp = new int[256];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i)]++;
        }

        // 统计奇数字符个数
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (temp[i] % 2 != 0) {
                count++;
            }
        }

        return count == 0 ? s.length() : (s.length() - count + 1);
    }

}
