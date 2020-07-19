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
        int right = 0;
        int count = 0;
        int left = 0;
        int res = 0;
        while (right < length) {
            char rightCh = s.charAt(right);
            if (letters[rightCh] == 0) {
                letters[rightCh]++;
            }else if (letters[rightCh] > 0) {
                letters[rightCh]++;
                count++;
            }
            right++;

            while (count > 0) {
                char leftCh = s.charAt(left);
                if (letters[leftCh] > 1) {
                    count--;
                    letters[leftCh]--;
                }else if (letters[leftCh] == 1) {
                    letters[leftCh]--;
                }
                left++;
            }
            res = Math.max(res, right-left);
        }
        return res;
    }

}
