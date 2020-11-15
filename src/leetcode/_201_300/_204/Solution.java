package leetcode._201_300._204;

import java.util.Arrays;

public class Solution {

    public int countPrimes(int n) {
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);

        for (int i = 2; i * i < n+1; i++) {
            if (arr[i]) {
                for (int j = i * i; j < n + 1; j += i) {
                    arr[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i]) {
                count++;
            }
        }
        return count;
    }

}
