package lintcode._062;

public class Solution {


    public int search(int[] A, int target) {
        // write your code here
        int length = A.length;
        if (length < 1){
            return -1;
        }
        int left = 0;
        int right = length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (A[mid] == target){
                return mid;
            }
            if (A[mid] > A[left]){
                if (A[left] <= target && target <= A[mid]){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }else{
                if (A[mid] <= target && target <= A[right-1]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
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
