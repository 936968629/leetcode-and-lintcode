package lintcode._075;

public class Solution {

    public int findPeak(int[] A) {
        // write your code here

        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right){

            int mid = left + (right - left) / 2;
            if (A[mid] < A[mid - 1]){
                right = mid;
            }else if(A[mid] < A[mid + 1]){
                left = mid;
            }else{
                return mid;
            }

        }

        if (A[left]>A[right]){
            return left;
        }
        return right;

    }

}
