package leetcode._201_300._278;

public class Solution {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            int midder = left + (right - left) / 2;
            if (isBadVersion(midder)) {
                right = midder;
            }else {
                left = midder;
            }
        }
        if ( isBadVersion(left) ) {
            return left;
        }
        return right;
    }

    boolean isBadVersion(int version) {
        return true;
    }

}
