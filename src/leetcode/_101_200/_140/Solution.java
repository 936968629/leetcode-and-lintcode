package leetcode._101_200._140;

import java.util.*;

public class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;

        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        if(dp[length]) {
            StringBuilder sb = new StringBuilder();
            dfs(result, dp, set, 0, length, sb, s);
        }
        return result;
    }

    public void dfs(List<String> result, boolean[] dp, Set<String> set, int index, int end, StringBuilder sb, String s) {
        if (set.contains(s.substring(0, end))) {
            sb.insert(0, s.substring(0,end) + " ");
            result.add(sb.toString().trim());
            sb.delete(0, end+1);
        }

        for (int i = end - 1; i >= 0; i--) {
            String substring = s.substring(i, end);
            if (dp[i] && set.contains(substring)) {
                sb.insert(0, substring+" ");
                dfs(result, dp, set, index, i, sb, s);
                sb.delete(0, substring.length() + 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        solution.wordBreak(s, wordDict);
    }
}
