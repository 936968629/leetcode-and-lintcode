package lintcode._532;

public class Solution {

    public long reversePairs(int[] A) {
        // write your code here

        int result = 0;

        for (int i=0; i<A.length;i++){
            for (int j = i+1;j<A.length;j++){
                if (A[i] > A[j]){
                    result+=1;
                }
            }
        }


        return result;

    }

}
