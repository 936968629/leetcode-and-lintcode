package leetcode._001_100._028;

public class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int M = needle.length();
        int N = haystack.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (needle.charAt(j) != haystack.charAt(i+j))
                    break;
            }
            // pat 全都匹配了
            if (j == M) return i;
        }
        // txt 中不存在 pat 子串
        return -1;

    }

}
