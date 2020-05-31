package lintcode._001_100._063;

public class Solution {

    public boolean search(int[] A, int target) {
        int length = A.length;
        if ( length == 0 ) {
            return false;
        }

        for (int i = 0; i < A.length; i++) {
            if ( A[i] == target ) {
                return true;
            }
        }
        return false;
    }


}
