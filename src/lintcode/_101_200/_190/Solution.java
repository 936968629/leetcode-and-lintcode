package lintcode._101_200._190;

public class Solution {

    public void nextPermutation(int[] nums) {
        // write your code here
        int length = nums.length;
        if ( length == 0 ) {
            return;
        }
        //从末尾找到第一个大于前一个的位置
        int i = length - 1;
        while ( i > 0 ) {
            if ( nums[i] > nums[i-1] ) {
                break;
            }
            i--;
        }
        //直接翻转
        if ( i == 0 ) {
            reverse(nums, 0, length - 1);
            return;
        }
        // i > 0
        //末尾开始找到第一个大于等于该值
        int j = length - 1;
        while ( nums[i-1] >= nums[j] ) {
            j--;
        }
        swap(nums, i-1, j);
        reverse(nums, i, length - 1);
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
