package lintcode._001_100._003;

public class Solution {

    public int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        for (int i = 0; i <= n; i++) {
            count += countItem(k, i);
        }
        return count;
    }

    public int countItem(int k, int item) {
        if( k==0 && item == 0){
            return 1;
        }
        int count = 0;
        while ( item > 0 ) {
            if ( item % 10 == k ) {
                count++;
            }
            item = item / 10;
        }
        return count;
    }

}
