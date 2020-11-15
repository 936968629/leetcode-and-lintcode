package leetcode._1122;

public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int[] count = new int[1001];

        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]] = count[arr1[i]] + 1;
        }

        int signal = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < count[arr2[i]]; j++) {
                result[signal] = arr2[i];
                signal++;
                if (j == count[arr2[i]] - 1) {
                    count[arr2[i]] = 0;
                }
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < count[i]; j++) {
                    result[signal] = i;
                    signal++;
                }
            }
        }
        return result;
    }

}
