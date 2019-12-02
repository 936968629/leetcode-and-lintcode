package lintcode._075;

public class Solution {

    public int findPeak(int[] A) {
        // write your code here

        int left = 0;
        int right = A.length - 2;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if ( A[mid] > A[mid-1]  && A[mid] < A[mid +1]) {
                //上升
                left = mid;
            }else if ( A[mid] < A[mid-1]  && A[mid] > A[mid +1] ) {
                //下降
                right = mid;
            }else if ( A[mid] > A[mid-1] && A[mid] > A[mid+1]) {
                //有峰值
                return mid;
            }else {
                //有谷底,无所谓
                left = mid;
                //right = mid;
            }

        }

        if (A[left]>A[right]){
            return left;
        }
        return right;

    }

}
