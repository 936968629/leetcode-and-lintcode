package lintcode._001_100._031;

public class Solution {

    public int partitionArray(int[] nums, int k) {
        // write your code here
        int length = nums.length;
        if ( length == 0 ) {
            return 0;
        }

        int i = 0;
        int j = length - 1;
        while ( i <= j ) {
            if ( nums[i] < k ) {
                i++;
            }
            if ( nums[j] >= k ) {
                j--;
            }
            if ( i < j ) {
                swap(nums, i, j);
            }

        }
        return i;

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
