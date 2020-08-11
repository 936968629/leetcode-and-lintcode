package leetcode._001_100._076;

public class Solution {

    public String minWindow(String s, String t) {
        int tLength = t.length();
        if (tLength == 0) {
            return "";
        }
        int[] mapt = new int[256];
        int[] maps = new int[256];
        for (int i = 0; i < tLength; i++) {
            mapt[t.charAt(i)]++;
        }


        int left = 0;
        int right = 0;
        int signal = 0;
        String res = "";
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char rightC = s.charAt(right);
            if (mapt[rightC] > 0) {
                maps[rightC]++;
                if (mapt[rightC] >= maps[rightC]) {
                    signal++;
                }
            }

            right++;
            while (signal == tLength) {

                if (right-left < len) {
                    len = right-left;
                    res = s.substring(left, right);
                }
                char leftC = s.charAt(left);
                if (mapt[leftC] > 0) {
                    if (mapt[leftC] >= maps[leftC]) {
                        signal--;
                    }
                    maps[leftC]--;
                }
                left++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aa";
        String t = "aa";

        System.out.println(solution.minWindow(s, t));
    }
}
