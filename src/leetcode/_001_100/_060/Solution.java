package leetcode._001_100._060;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        boolean[] visited = new boolean[n];
        List<String> result = new ArrayList<>();
        dfs(result, nums, new StringBuilder(), k, visited);

        return result.get(k-1);
    }

    public void dfs(List<String> result, int[] nums, StringBuilder item, int k, boolean[] visited) {

        if (result.size() > k) {
            return;
        }

        if (item.length() == nums.length) {
            result.add(item.toString());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            item.append(nums[i]);
            visited[i] = true;
            dfs(result, nums, item, k, visited);
            visited[i] = false;
            item.deleteCharAt(item.length()-1);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getPermutation(4,3);
    }

}
