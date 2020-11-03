package leetcode._986;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int lenA = A.length;
        int lenB = B.length;

        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();

        while (i < lenA && j < lenB) {
            int[] itemA = A[i];
            int[] itemB = B[j];
            if (itemA[1] < itemB[0] || itemA[0] > itemB[1]) {
                //无交集
            }else {
                int[] item = new int[2];
                item[0] = Math.max(itemA[0], itemB[0]);
                item[1] = Math.min(itemA[1], itemB[1]);
                result.add(item);
            }
            if (itemA[1] > itemB[1]) {
                j++;
            }else {
                i++;
            }
        }

        return result.toArray(new int[0][]);
    }

}
