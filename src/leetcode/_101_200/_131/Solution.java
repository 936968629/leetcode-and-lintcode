package leetcode._101_200._131;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int length = s.length();
        if (length == 0) {
            return result;
        }
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        for (int i = length-1; i >= 0; i--) {
            for (int j = i+1; j < length; j++) {
                if (s.charAt(j) == s.charAt(i) && (dp[i+1][j-1] || j - i < 2) ) {
                    dp[i][j] = true;
                }
            }
        }
        dfs(result, new ArrayList<>(), length, 0, dp, s);
        return result;
    }

    public void dfs(List<List<String>> result, List<String> item, int length, int index, boolean[][] dp, String s) {
        if (index == length) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = index; i < length; i++) {
            if (dp[index][i]) {
                item.add(s.substring(index, i+1));
                dfs(result, item, length, i+1, dp, s);
                item.remove(item.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.partition("aab");
    }
}
