package lintcode._001_100._074;

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */

    public int findFirstBadVersion(int n) {
        // write your code here

        if(n <= 1){
            return lintcode._001_100._074.SVNRepo.isBadVersion(1) ? 1:-1;
        }
        int left = 1;
        int right = n;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (lintcode._001_100._074.SVNRepo.isBadVersion(mid)){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(SVNRepo.isBadVersion(left)){
            return left;
        }
        return right;
    }
}
