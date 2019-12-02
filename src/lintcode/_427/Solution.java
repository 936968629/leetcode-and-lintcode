package lintcode._427;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        // write your code here

        List<String> res = new ArrayList<>();
        dfs(res, n, 0, 0, "");
        return res;
    }

    public void dfs(List<String> res, int n, int left, int right, String path){
        if (left == n && right == n){
            res.add(path);
            return;
        }

        if (left < right){
            return;
        }

        if (left > n ){
            return;
        }

        dfs(res, n, left+1, right, path+"(");
        dfs(res, n, left, right+1, path+")");

    }

}
