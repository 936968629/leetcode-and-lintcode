package leetcode._101_200._123;

public class Solution {


    public int maxProfit(int[] prices) {
        //[3,3,5,0,0,3,1,4]
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int[] s1 = new int[length+1];
        int[] s2 = new int[length+1];
        int[] s3 = new int[length+1];
        int[] s4 = new int[length+1];

        s1[0] = Integer.MIN_VALUE;
        s2[0] = 0;
        s3[0] = Integer.MIN_VALUE;
        s4[0] = 0;
        for (int i = 1; i < length + 1; i++) {
            s1[i] = Math.max(s1[i-1], 0 - prices[i-1]);
            s2[i] = Math.max(s2[i-1], s1[i-1] + prices[i-1]);
            s3[i] = Math.max(s3[i-1], s2[i-1] - prices[i-1]);
            s4[i] = Math.max(s4[i-1], s3[i-1] + prices[i-1]);
        }
        return Math.max(s2[length], s4[length]);
    }
}
