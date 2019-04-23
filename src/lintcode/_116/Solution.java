package lintcode._116;

public class Solution {

    public boolean canJump(int[] A) {
        // write your code here
        int length = A.length;
        if (length == 0){
            return false;
        }
        if (A[0] == 0){
            return false;
        }
        int reach = 0;
        for (int i = 0; i <= reach ; i++) {
            if (reach < A[i] + i){
                reach = i + A[i];
            }
            if (reach >= length-1){
                return true;
            }
        }
        return false;
    }

}
