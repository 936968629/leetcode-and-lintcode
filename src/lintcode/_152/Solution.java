package lintcode._152;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        if (n < k){
            return res;
        }

        dfs(n, k, 0, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int n, int k,int index, int curNum, List<Integer> cur){

        if (index == k){
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = curNum+1; i <= n; i++) {
            cur.add(i);
            dfs(n, k , index+1, i, cur);
            cur.remove(cur.size()-1);
        }

    }

}
