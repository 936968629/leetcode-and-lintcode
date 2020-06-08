package lintcode._101_200._150;

public class Solution {

    public int maxProfit(int[] prices) {
        // write your code here
        if ( prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = max + Math.max(0, prices[i]-prices[i-1]);
        }
        return max;
    }

}
