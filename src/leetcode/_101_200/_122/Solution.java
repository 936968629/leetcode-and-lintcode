package leetcode._101_200._122;

public class Solution {

    public int maxProfit(int[] prices) {
        int res = 0;
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        for (int i = 1; i < length; i++) {
            if (prices[i] > prices[i-1]) {
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }

}
