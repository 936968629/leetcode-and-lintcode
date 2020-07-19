package leetcode._101_200._188;

public class Solution {

    public int maxProfit(int k, int[] prices) {
        //[3,2,6,5,0,3], k = 2
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        if (k > prices.length / 2) {
            return maxProfitOfII(prices);
        }
        int[][] dp = new int[2*k][length + 1];
        for (int i = 0; i < 2 * k; i++) {
            if (i % 2 == 0) {
                dp[i][0] = Integer.MIN_VALUE;
            }else {
                dp[i][0] = 0;
            }
        }
        int res = 0;
        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j < 2 * k; j++) {
                if (j == 0) {
                    dp[j][i] = Math.max(dp[j][i-1], 0-prices[i-1]);
                }else if (j % 2 == 1) {
                    dp[j][i] = Math.max(dp[j][i-1], dp[j-1][i-1]+prices[i-1]);
                    res = Math.max(res, dp[j][i]);
                }else if (j % 2 == 0) {
                    dp[j][i] = Math.max(dp[j][i-1], dp[j-1][i-1]-prices[i-1]);
                }
            }
        }
        return res;
    }


    // 解决无限次交易的方法
    public int maxProfitOfII(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {2,1,2,0,1};
        solution.maxProfit(2, prices);
    }

}
