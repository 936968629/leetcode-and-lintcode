package leetcode._901_1000._922;

public class Solution {

    public int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        if (length == 0) {
            return A;
        }
        // 0 3
        int i = 0;
        int j = 1;

        for (i = 0; i < length; i+=2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j+=2;
                }
                swap(A, i, j);
            }
        }

        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
