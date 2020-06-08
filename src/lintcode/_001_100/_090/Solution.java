package lintcode._001_100._090;

import java.util.*;

public class Solution {

    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (A == null || A.length == 0 || k == 0) {
            return result;
        }
        Arrays.sort(A);
        dfs(A, 0, k, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] A, int startIndex, int remainCount, int remainTarget, List<Integer> subset, List<List<Integer>> result) {
        if (remainTarget == 0 && remainCount == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }
        if (remainCount == 0) {
            return;
        }
        for (int i = startIndex; i < A.length; i++) {
            if (A[startIndex] > remainTarget) {
                break;
            }
            subset.add(A[i]);
            dfs(A, i + 1, remainCount - 1, remainTarget - A[i], subset, result);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1,2,3,4};
        solution.kSumII(A, 2, 5);
    }

}
