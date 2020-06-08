package lintcode._101_200._148;

public class Solution {

    public void sortColors(int[] nums) {
        // write your code here
        //计数排序
        int length = nums.length;
        if ( nums == null || length == 0 ) {
            return;
        }
        int q = 0;
        int w = 0;
        int e = 0;
        for ( int item : nums ) {
            if ( item == 0 ) {
                q++;
            } else if ( item == 1 ) {
                w++;
            } else if ( item == 2 ) {
                e++;
            }
        }
        int k = 0;
        for (int i = 0; i < q; i++) {
            nums[k] = 0;
            k++;
        }
        for (int i = 0; i < w; i++) {
            nums[k] = 0;
            k++;
        }
        for (int i = 0; i < e; i++) {
            nums[k] = 0;
            k++;
        }


    }

}
