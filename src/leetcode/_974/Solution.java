package leetcode._974;

public class Solution {

    public int subarraysDivByK(int[] A, int K) {
        int length = A.length;
        if (length == 0) {
            return 0;
        }

        int[] prefix = new int[length + 1];
        prefix[0] = 0;
        for (int i = 1; i < length + 1; i++) {
            prefix[i] = prefix[i-1] + A[i-1];
        }
        int res = 0;
        for (int i = 0; i < length + 1; i++) {
            for (int j = i+1; j < length + 1; j++) {
                if ((prefix[j] - prefix[i]) % K == 0) {
                    res++;
                }
            }
        }

        return res;
    }

}
