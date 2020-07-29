package leetcode._001_100._077;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0) {
            return result;
        }
        dfs(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, int k, int n, int index) {
        if (item.size() == k) {
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i = index; i <= n; i++) {
            item.add(i);
            dfs(result, item, k, n, i+1);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = {1,2,3};
        List<List<Integer>> combine = solution.combine(3,1);
        System.out.println(combine.toString());
    }
}
