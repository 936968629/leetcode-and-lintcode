package leetcode._101_200._135;

import java.util.Arrays;

public class Solution {

    public int candy(int[] ratings) {
        int length = ratings.length;
        if (length == 0) {
            return 0;
        }

        int[] leftToRight = new int[length];
        int[] rightToLeft = new int[length];
        Arrays.fill(leftToRight, 1);
        Arrays.fill(rightToLeft, 1);

        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i-1]) {
                leftToRight[i] = leftToRight[i-1] + 1;
            }
        }

        for (int i = length - 2; i >= 0 ; i--) {
            if (ratings[i] > ratings[i+1] ) {
                rightToLeft[i] = rightToLeft[i+1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Math.max(rightToLeft[i], leftToRight[i]);
        }
        return sum;
    }

}
