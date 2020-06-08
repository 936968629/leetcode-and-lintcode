package lintcode._001_100._061;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] res = new int[2];
        if (A.length == 0){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
//        int left = 0;
//        int right = A.length;
//        int sign = -1;
//        while (left < right){
//            int mid = left + (right - left) / 2;
//            if (A[mid] == target){
//                sign = mid;
//                right = mid;
//            }else if(A[mid] < target){
//                left = mid+1;
//            }else{
//                right = mid;
//            }
//        }
//        if (sign == -1){
//            res[0] = -1;
//            res[1] = -1;
//            return res;
//        }
//        int Lleft = sign;
//        int Lright = sign;
//
//        while (Lleft > 0 && A[Lleft] == A[Lleft-1] ){
//            Lleft--;
//        }
//        while ( Lright < A.length-1 && A[Lright] == A[Lright+1]){
//            Lright++;
//        }
//        res[0] = Lleft;
//        res[1] = Lright;
//        return res;
        res[0] = findFirst(A, target);
        res[1] = findLast(A, target);
        return res;
    }

    public int findFirst(int[] num, int target) {
        int length = num.length;
        int left = 0;
        int right = length - 1;
        while ( left + 1 < right ) {
            int mid = left + (right - left) /2 ;
            if ( num[mid] == target ) {
                right = mid;
            }else if ( num[mid] > target) {
                right = mid;
            }else{
                left = mid;
            }
        }
        if ( num[left] == target ){
            return left;
        }
        if ( num[right] == target ){
            return right;
        }
        return -1;
    }

    public int findLast(int[] num, int target){
        int length = num.length;
        int left = 0;
        int right = length - 1;
        while ( left + 1 < right ) {
            int mid = left + (right - left) /2 ;
            if ( num[mid] == target ) {
                left = mid;
            }else if ( num[mid] > target) {
                right = mid;
            }else{
                left = mid;
            }
        }
        if ( num[right] == target ){
            return right;
        }
        if ( num[left] == target ){
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {1};
        sol.searchRange(A, 1);
    }
}
