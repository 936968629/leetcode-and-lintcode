package leetcode._501_600._567;

public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        if (length1 == 0) {
            return true;
        }

        int[] map1 = new int[128];
        int[] map2 = new int[128];
        for (int i = 0; i < length1; i++) {
            map1[s1.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int signal = 0;

        while (right < s2.length()) {
            char rightC = s2.charAt(right);
            if (map1[rightC] > 0) {
                map2[rightC]++;
                if (map1[rightC] >= map2[rightC]) {
                    signal++;
                }
            }

            right++;

            while (signal == length1) {

                if (right - left == length1) {
                    return true;
                }
                char leftC = s2.charAt(left);
                if (map1[leftC] > 0) {
                    if (map1[leftC] >= map2[leftC]) {
                        signal--;
                    }
                    map2[leftC]--;
                }
                left++;
            }

        }

        return false;

    }

}
