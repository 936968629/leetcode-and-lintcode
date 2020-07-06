package leetcode._301_400._374;

public class Solution {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            }else if (guess(mid) > 0) {
                left = mid;
            }else {
                right = mid;
            }
        }
        if (guess(left) == 0) {
            return left;
        }
        return right;
    }

    public int guess(int num) {
        return 1;
    }

}
