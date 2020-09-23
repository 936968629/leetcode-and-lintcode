package leetcode._001_100._003;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int[] letters = new int[256];
        int res = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < length) {
            char item = s.charAt(right);
            if (letters[item] == 0) {
                letters[item] = 1;
            }else {
                letters[item]++;
                count++;
            }

            while (count > 0) {
                char leftCh = s.charAt(left);
                if (letters[leftCh] > 1) {
                    count--;
                    letters[leftCh]--;
                }else {
                    letters[leftCh] = 0;
                }
                left++;
            }
            res = Math.max(res, right-left+1);
            right++;
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }

        int[] show = new int[256];

        int left = 0;
        int right = 0;
        int res = 0;
        while (right < length) {
            if (show[s.charAt(right)] == 0) {
                show[s.charAt(right)]++;
            }else {
                show[s.charAt(right)]++;
                while (show[s.charAt(right)] > 1) {
                    char leftC = s.charAt(left);
                    show[leftC]--;
                    left++;
                }
            }

            res = Math.max(right-left+1, res);
            right++;
        }
        return res;
    }

}
