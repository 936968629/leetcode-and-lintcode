package lintcode._101_200._149;

public class Solution {


    public int maxProfit(int[] prices) {
        // write your code here
        int length = prices.length;
        if (length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i]-min);
        }

        return res;
    }

}
