package leetcode.jianzhiOffer._0811;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int res;

    public int waysToChange(int n) {
        //币值为25分、10分、5分和1分
        if (n == 0) {
            return 0;
        }
        int[] coins = {1,5,10,25};
        dfs(new ArrayList<>(), n, 0, coins);
        return res;
    }

    public void dfs(List<Integer> item, int target, int index, int[] coins) {
        if (target == 0) {
            res++;
//            result.add(new ArrayList<>(item));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < coins.length; i++) {
            item.add(coins[i]);
            dfs(item, target - coins[i], i, coins);
            item.remove(item.size()-1);
        }
    }

    public int waysToChange2(int n) {
        //币值为25分、10分、5分和1分
        if (n == 0) {
            return 0;
        }
        int[] coins = {1,5,10,25};
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < n+1; j++) {
                if (j-coins[i] >= 0) {
                    dp[j] = (dp[j] + dp[j-coins[i]]) % 1000000007;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.waysToChange2(5));
    }

}
