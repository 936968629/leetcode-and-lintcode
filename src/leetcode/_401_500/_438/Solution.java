package leetcode._401_500._438;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int lengthP = p.length();

        int[] mapP = new int[128];
        int[] mapS = new int[128];
        for (int i = 0; i < lengthP; i++) {
            mapP[p.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int singal = 0;

        while (right < s.length()) {
            char rightC = s.charAt(right);
            if (mapP[rightC] > 0) {
                mapS[rightC]++;
                if (mapP[rightC] >= mapS[rightC]) {
                    singal++;
                }
            }
            right++;

            while (singal == lengthP) {
                if (right-left == lengthP) {
                    result.add(left);
                }
                char leftC = s.charAt(left);
                if (mapP[leftC] > 0) {
                    mapS[leftC]--;
                    if (mapP[leftC] > mapS[leftC]) {
                        singal--;
                    }

                }
                left++;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s= "cbaebabacd";
        String t = "abc";
        solution.findAnagrams(s, t);
    }

}
