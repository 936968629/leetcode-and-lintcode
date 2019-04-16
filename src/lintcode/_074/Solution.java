package lintcode._074;

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */

    public int findFirstBadVersion(int n) {
        // write your code here

        if(n <= 1){
            return SVNRepo.isBadVersion(1) ? 1:-1;
        }
        int left = 1;
        int right = n;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (SVNRepo.isBadVersion(mid)){
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
