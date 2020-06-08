package lintcode._1901;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] SquareArray(int[] A) {
        int length = A.length;
        if ( length == 0 ) {
            return new int[0];
        }
        int[] res = new int[length];
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if ( A[i] < 0 ) {
                min.add(0, A[i] * A[i]);
            } else {
                max.add(A[i]*A[i]);
            }
        }
        return merge(min, max);
    }

    public int[] merge(List<Integer> min, List<Integer> max) {
        int[] res = new int[min.size() + max.size()];
        int i = 0;
        int j = 0;
        int k = 0;
        while ( i < min.size() && j < max.size() ) {
            if ( min.get(i) < max.get(j) ) {
                res[k] = min.get(i);
                k++;
                i++;
            } else {
                res[k] = max.get(j);
                k++;
                j++;
            }
        }

        while ( i < min.size() ) {
            res[k] = min.get(i);
            k++;
            i++;
        }

        while ( j < max.size() ) {
            res[k] = max.get(j);
            k++;
            j++;
        }

        return res;
    }
}
