package leetcode.jianzhiOffer._0806;

import java.util.List;

public class Solution {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int size = A.size();
        if (size == 0) {
            return;
        }
        dfs(size, A, B, C);
    }

    /**
     * 将A第n个数移动C
     */
    public void dfs(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size()-1));
        }else {
            B.add(A.remove(A.size()-1));
            dfs(n-1,  A,  B,  C);
            C.add(B.remove(B.size()-1));
        }
    }

}
