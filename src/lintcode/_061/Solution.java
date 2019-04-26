package lintcode._061;

public class Solution {

    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] res = new int[2];
        if (A.length < 1){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int left = 0;
        int right = A.length;
        int sign = -1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (A[mid] == target){
                sign = mid;
                right = mid;
            }else if(A[mid] < target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        if (sign == -1){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int Lleft = sign;
        int Lright = sign;
        //xxl-job
        while (Lleft > 0 && A[Lleft] == A[Lleft-1] ){
            Lleft--;
        }
        while ( Lright < A.length-1 && A[Lright] == A[Lright+1]){
            Lright++;
        }
        res[0] = Lleft;
        res[1] = Lright;
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {1};
        sol.searchRange(A, 1);
    }
}
