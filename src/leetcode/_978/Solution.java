package leetcode._978;

import java.util.Arrays;

public class Solution {

    public int maxTurbulenceSize(int[] A) {
        int length = A.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        //最后为上升
        int[] dp1 = new int[length+1];
        //最后为下降
        int[] dp2 = new int[length+1];
        dp1[0] = 0;
        dp2[0] = 0;
        dp1[1] = 1;
        dp2[1] = 1;

        int res = 1;
        for (int i = 2; i < length + 1; i++) {
            if (A[i-1] > A[i-2]) {
                //上升
                dp1[i] = dp2[i-1] + 1;
                dp2[i] = 1;
            }else if (A[i-1] < A[i-2]) {
                //下降
                dp1[i] = 1;
                dp2[i] = dp1[i-1] + 1;
            }else {
                dp1[i] = 1;
                dp2[i] = 1;
            }
            res = Math.max(res, Math.max(dp1[i], dp2[i]));

        }

        return res;
    }

}
