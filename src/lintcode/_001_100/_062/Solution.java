package lintcode._001_100._062;

public class Solution {


    public int search(int[] A, int target) {
        // write your code here
        int length = A.length;
        if (length < 1){
            return -1;
        }
        int left = 0;
        int right = length - 1;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (A[mid] == target){
                return mid;
            }
            if (A[mid] > A[left]){
                if (A[left] <= target && target <= A[mid]){
                    right = mid;
                }else{
                    left = mid;
                }
            }else{
                if (A[mid] <= target && target <= A[right]){
                    left = mid;
                }else{
                    right = mid;
                }
            }
        }

        if ( A[left] == target ){
            return left;
        }
        if ( A[right] == target ){
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {6,8,9,1,3,5};
        int target = 5;
        int search = sol.search(A, target);
        System.out.println(search);
    }

}
