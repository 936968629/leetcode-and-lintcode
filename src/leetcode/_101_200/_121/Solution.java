package leetcode._101_200._121;

public class Solution {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        int[] s1 = new int[length + 1];
        int[] s2 = new int[length + 1];
        s1[0] = Integer.MIN_VALUE;
        s2[0] = 0;
        for (int i = 1; i < length + 1; i++) {
            s1[i] = Math.max(s1[i-1], 0-prices[i-1]);
            s2[i] = Math.max(s2[i-1], s1[i-1] + prices[i-1]);
        }
        return s2[length];
    }

}
