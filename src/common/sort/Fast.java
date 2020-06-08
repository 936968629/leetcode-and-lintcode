package common.sort;

import java.util.Arrays;

public class Fast {

    public void quicksort(int[] nums, int left, int right){
        if ( left >= right ) {
            return;
        }
        int mid = partitoin(nums, left, right);
        quicksort(nums, left, mid - 1);
        quicksort(nums, mid + 1, right);
    }

    public int partitoin(int[] nums, int left, int right){
        int flag = nums[right];
        int i = left;
        int j = right - 1;
        while ( i <= j) {

            while ( i <= j && nums[i] <= flag) {
                i++;
            }
            while ( i <= j && nums[j] > flag) {
                j--;
            }

            if ( i < j ) {
                swap(nums, i, j);
            }

        }

        swap( nums, i, right );
        return i;
    }

    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        Fast fast = new Fast();
        int[] nums = {1,4,9,10,33,2,34,56,11,99,0};
        fast.quicksort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

}
