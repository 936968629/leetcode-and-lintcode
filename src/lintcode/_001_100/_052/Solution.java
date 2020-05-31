package lintcode._001_100._052;

public class Solution {

    public int[] nextPermutation(int[] nums) {
        // write your code here
        int length = nums.length;
        if ( length <= 1 ) {
            return nums;
        }

        int i = length - 1;
        while ( i > 0 ) {
            if ( nums[i] > nums[i-1] ) {
                break;
            }
            i--;
        }

        if ( i == 0 ) {
            reverse(nums, 0 , length -1);
            return nums;
        }
        // i> 0
        int j = length - 1;
        while ( nums[i-1] >= nums[j] ) {
            j--;
        }
        swap(nums, i-1, j);
        reverse(nums, i, length - 1);
        return nums;
    }

    public void reverse(int[] nums, int start, int end) {
        while ( start < end ) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
