package lintcode._116;

public class Solution {

    public boolean canJump(int[] A) {
        // write your code here
<<<<<<< HEAD



        return false;

=======
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
>>>>>>> 90043515c2c99e1e7490b18c478cac5f3f9a7240
    }

}
