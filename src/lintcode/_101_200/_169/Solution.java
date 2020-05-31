package lintcode._101_200._169;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public List<String> towerOfHanoi(int n) {
        // write your code here
        List<String> res = new ArrayList<>();
        dfs(n, "A", "C", "B", res);
        return res;
    }

    public void dfs(int n, String from, String to, String temp, List<String> res){
        if (n == 1){
            String str = "from "+from+" to "+to;
            res.add(str);
            return;
        }
        dfs(n-1, from, temp, to, res);
        dfs(1, from, to, temp, res);
        dfs(n-1, temp, to, from, res);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.towerOfHanoi(4));
    }

}
