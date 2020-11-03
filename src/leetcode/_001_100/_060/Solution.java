package leetcode._001_100._060;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String getPermutation(int n, int k) {
        List<String> result = new ArrayList<>();
        boolean[] visited = new boolean[n+1];

        dfs(result, new StringBuilder(), k, n, 0, visited);

        return result.get(k-1);
    }

    public void dfs(List<String> result, StringBuilder sb, int k, int n, int index, boolean[] visited) {
        if (result.size() > k) {
            return;
        }

        if (sb.length() == n) {
            result.add(sb.toString());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                sb.append(i);
                visited[i] = true;
                dfs(result, sb, k, n, index, visited);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getPermutation(4,3);
    }

}
