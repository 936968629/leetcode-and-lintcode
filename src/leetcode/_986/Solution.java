package leetcode._986;

public class Solution {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int lenA = A.length;
        int lenB = B.length;

        int i = 0;
        int j = 0;
        while (i < lenA && j < lenB) {
            int[] itemA = A[i];
            int[] itemB = B[i];
            if (itemA[1] < itemB[0] || itemA[0] > itemB[1]) {

            }
        }

        return null;
    }

}
