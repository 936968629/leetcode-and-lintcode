package leetcode._001_100._022;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        if (n == 1) {
            result.add("()");
            return result;
        }
        dfs(result, "", n, n, n);
        return result;
    }

    public void dfs(List<String> result, String item, int n, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(item);
            return;
        }
        if (left > 0) {
            dfs(result, item+"(", n, left-1, right);
        }
        if (right > left) {
            dfs(result, item+")",n, left, right-1);
        }
    }
}
