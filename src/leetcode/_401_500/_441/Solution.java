package leetcode._401_500._441;

public class Solution {

    public int arrangeCoins(int n) {
        //0、1、2、3……n 行阶梯需要的硬币数是 [0, 1, 3, 6, ...., (1+n)n/2]
        if (n == 1) {
            return 1;
        }
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            float partition = (float) (mid + 1) * mid / 2;
            if (partition == n) {
                return mid;
            }else if(partition <  n){
                left = mid;
            }else {
                right = mid;
            }
        }
        if ((left + 1) * left / 2 <= n) {
            return left;
        }
        return right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.arrangeCoins(1804289383);
    }

}
